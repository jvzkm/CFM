package com.train.app.service.impl;

import com.train.app.dao.repository.BaseTicketRepository;
import com.train.app.model.dto.SeatBooking;
import com.train.app.model.dto.TicketRequest;
import com.train.app.model.entity.BaseTicket;
import com.train.app.model.mapper.TicketMapper;
import com.train.app.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final BaseTicketRepository baseTicketRepository;
    private final TicketMapper mapper;

    @Override
    public List<SeatBooking> getSeatBookings(int traved_id, int start_index, int end_index) {
        return baseTicketRepository.findAll()
                .stream()
                .filter(temp -> temp.getTravel().getId() == traved_id)
                .filter(temp -> temp.getBoardingStationIndex() >= start_index && temp.getExitStationIndex() <= end_index)
                .map(ticket -> new SeatBooking(ticket.getSeatNumber(), ticket.getVagonIndex()))
                .collect(Collectors.toList());
    }

    @Override
    public BaseTicket createTicket(TicketRequest request) {
        return baseTicketRepository.save(mapper.toTicket(request));
    }
}

