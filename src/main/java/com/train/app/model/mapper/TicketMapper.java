package com.train.app.model.mapper;


import com.train.app.model.entity.BaseTicket;
import com.train.app.model.dto.TicketRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    @Mapping(target = "travel", source = "travelResult.travel")
    @Mapping(target = "boardingStationIndex", source = "travelResult.startId")
    @Mapping(target = "exitStationIndex", source = "travelResult.endId")
    @Mapping(target = "seatNumber", source = "seatBooking.seatNo")
    @Mapping(target = "vagonIndex", source = "seatBooking.vagon_id")
    BaseTicket toTicket(TicketRequest request);
}
