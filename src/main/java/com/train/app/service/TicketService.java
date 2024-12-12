package com.train.app.service;



import com.train.app.model.dto.Person;
import com.train.app.model.dto.TravelResult;

import java.util.List;

public interface TicketService {

    void createTicket(Person person, List<TravelResult> travelResult);

}
