package com.train.app.service.impl;


import com.train.app.dao.repository.RouteRepository;
import com.train.app.dao.repository.RouteStationRepository;
import com.train.app.model.dto.TicketMetaData;
import com.train.app.model.dto.TravelResult;
import com.train.app.model.dto.UtilityResult;
import com.train.app.model.entity.Route;
import com.train.app.model.entity.Station;
import com.train.app.model.entity.Travel;
import com.train.app.service.RouteStationService;
import com.train.app.service.UtilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RouteStationServiceImpl implements RouteStationService {
    private final RouteStationRepository repository;
    private final RouteRepository routeRepository;
    private final UtilityService utilityService;

    @Override
    public Station getStationFromIndex(int index, int routeId) {
        Route route = routeRepository.findById(routeId).orElseThrow();
        return repository.findByIndexAndRoute(route, index).orElseThrow().getLineElement().getStation();
    }

    @Override
    public List<Station> getStationInBetween(TicketMetaData metaData) {
        return repository.getStationsInBetween(convert(metaData, metaData.getStartStation()),
                convert(metaData, metaData.getStopStation()), metaData.getTravel().getRouteId());
    }

    @Override
    public Integer convert(TicketMetaData metaData, Station station) {
        return repository.getIndexByStation(metaData.getTravel().getRouteId(), station.getId()).get();
    }

    @Override
    public List<TicketMetaData> squashResults(List<TravelResult> list, Integer startId) {
        if (list.size() == 1) {
            Result result = getResult(list, 0, startId);
            return Collections.singletonList(TicketMetaData.builder()
                    .departureTime(result.toStartTime())
                    .travel(result.travel())
                    .arrivalTime(result.toStartTime().plusMinutes(result.minutes()))
                    .startStation(repository.findByIndexAndRoute(result.travel().getRoute(),
                            result.travelResult().getStartId()).orElseThrow().getLineElement().getStation())
                    .stopStation(repository.findByIndexAndRoute(result.travel().getRoute(),
                            result.travelResult().getEndId()).orElseThrow().getLineElement().getStation())
                    .km(result.km())
                    .build());
        } else {
            List<TicketMetaData> ticketMetaData = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Result startPoint = getResult(list, i, startId);
                ticketMetaData.add(TicketMetaData.builder()
                        .departureTime(startPoint.toStartTime())
                        .travel(startPoint.travel())
                        .km(startPoint.km())
                        .arrivalTime(startPoint.toStartTime().plusMinutes(startPoint.minutes()))
                        .startStation(repository.findByIndexAndRoute(startPoint.travel().getRoute(),
                                startPoint.travelResult().getStartId()).orElseThrow().getLineElement().getStation())
                        .stopStation(repository.findByIndexAndRoute(startPoint.travel().getRoute(),
                                startPoint.travelResult().getEndId()).orElseThrow().getLineElement().getStation())
                        .build());
            }
            log.info("{}", ticketMetaData);
            return ticketMetaData;

        }
    }

    private Result getResult(List<TravelResult> list, int index, int startId) {
        TravelResult travelResult = list.get(index);
        Travel travel = travelResult.getTravel();

        TravelResult prevResult = TravelResult.builder()
                .travel(travel)
                .startId(0)
                .endId(travelResult.getStartId())
                .build();

        var toStartTime = travel.getStartDateTime().plusMinutes(utilityService.calculateDistanceAndDuration(prevResult).getMinutes());
        UtilityResult utilityResult = utilityService.calculateDistanceAndDuration(travelResult);
        long minutes = utilityResult.getMinutes();
        double distance = utilityResult.getKm();
        return new Result(travelResult, travel, minutes, distance, toStartTime);
    }

    private record Result(TravelResult travelResult, Travel travel, long minutes, double km,
                          LocalDateTime toStartTime) {
    }
}
