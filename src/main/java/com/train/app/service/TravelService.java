package com.train.app.service;


import com.train.app.model.entity.Travel;

import java.util.List;

public interface TravelService {

    Travel findTravelById(int id);

    List<Travel> getAllTravels();

    Travel addNewApartment(Travel apartment);
}
