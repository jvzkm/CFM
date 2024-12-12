package com.train.app.service.impl;

import com.train.app.dao.repository.TravelRepository;
import com.train.app.model.entity.Travel;
import com.train.app.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;

    @Override
    public Travel findTravelById(int id) {
        return travelRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    @Override
    public Travel addNewApartment(Travel apartment) {
        return travelRepository.save(apartment);
    }

}
