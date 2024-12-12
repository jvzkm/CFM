package com.train.app.service;


import com.train.app.model.dto.SeatBooking;
import com.train.app.model.dto.TicketRequest;
import com.train.app.model.entity.BaseTicket;

import java.util.List;

public interface TicketService {


    List<SeatBooking> getSeatBookings(int traved_id, int start_index, int end_index);

    BaseTicket createTicket(TicketRequest request);
}
