package com.train.app.util.raptor;


import com.train.app.dao.repository.RouteStationRepository;
import com.train.app.dao.repository.StationRepository;
import com.train.app.model.dto.TravelResult;
import com.train.app.model.entity.RouteStation;
import com.train.app.model.entity.Station;
import com.train.app.model.entity.Travel;
import com.train.app.service.UtilityService;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RaptorEntityMapper {

    private static final Logger log = LoggerFactory.getLogger(RaptorEntityMapper.class);
    private final StationRepository stationRepository;
    private final RouteStationRepository routeStationRepository;
    private final UtilityService utilityService;

    @Getter
    private Map<Integer, Stop> stopsMap;

    @PostConstruct
    public void init() {
        stopsMap = loadStops();
    }


    private Map<Integer, Stop> loadStops() {
        Map<Integer, Stop> stopsMap = new HashMap<>();

        List<Station> stations = stationRepository.findAll();
        for (Station station : stations) {
            Stop stop = new Stop(station.getId(), station.getStationName());
            stopsMap.put(station.getId(), stop);
        }

        List<RouteStation> routeStations = routeStationRepository.findAll();
        for (RouteStation routeStation : routeStations) {
            int currentStationId = routeStation.getLineElement().getStation().getId();
            int nextStationId = getNextStationId(routeStation);

            if (nextStationId != -1) {
                int routeId = routeStation.getRoute().getId();
                var start = 0;
                var end = 0;
                try {
                    start = routeStationRepository.getIndexByStation(routeId, currentStationId).orElseThrow();
                    end = routeStationRepository.getIndexByStation(routeId, nextStationId).orElseThrow();
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                var mock = createMockTravel(routeStation, start, end);
                long duration = utilityService.calculateDistanceAndDuration(mock).getMinutes();

                Stop stop = stopsMap.get(currentStationId);
                Connection connection = new Connection(nextStationId, routeId, duration);

                stop.addConnection(connection);
            }
        }

        return stopsMap;
    }

    private static TravelResult createMockTravel(RouteStation routeStation, int currentStationId, int nextStationId) {
        var tr = new Travel();
        tr.setRoute(routeStation.getRoute());
        return TravelResult.builder()
                .travel(tr)
                .startId(currentStationId)
                .endId(nextStationId)
                .build();
    }

    private int getNextStationId(RouteStation currentRouteStation) {
        Optional<RouteStation> nextRouteStation = routeStationRepository.findByRouteAndStationIndex(
                currentRouteStation.getRoute(), currentRouteStation.getStationIndex() + 1
        );
        return nextRouteStation.map(rs -> rs.getLineElement().getStation().getId()).orElse(-1);
    }
}
