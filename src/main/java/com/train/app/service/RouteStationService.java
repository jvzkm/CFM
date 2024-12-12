package com.train.app.service;

import com.train.app.model.dto.TicketMetaData;
import com.train.app.model.dto.TravelResult;
import com.train.app.model.entity.Station;

import java.util.List;

public interface RouteStationService {
    Station getStationFromIndex(int index, int routeId);

    List<Station> getStationInBetween(TicketMetaData metaData);

    Integer convert(TicketMetaData metaData, Station station);

    List<TicketMetaData> squashResults(List<TravelResult> list, Integer startId);
}
