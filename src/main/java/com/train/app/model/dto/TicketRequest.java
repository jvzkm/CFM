package com.train.app.model.dto;

import lombok.Data;

@Data
public class TicketRequest {
    private TravelResult travelResult;
    private SeatBooking seatBooking;
}
