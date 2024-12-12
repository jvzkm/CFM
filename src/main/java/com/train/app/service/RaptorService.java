package com.train.app.service;


import com.train.app.model.dto.TravelResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RaptorService {

    List<List<TravelResult>> searchForTravels(Integer startId,
                                              Integer endId,
                                              LocalDate dateTime,
                                              int numOfTickets);

    List<TravelResult> fastestTravelPossible(Integer start,
                                             Integer end,
                                             LocalDateTime dateTime,
                                             int numOfTickets);
}
