package com.train.app.service;


import com.train.app.model.dto.TravelResult;
import com.train.app.model.dto.UtilityResult;

public interface UtilityService {

    UtilityResult calculateDistanceAndDuration(TravelResult travelResult);

    long calculateDuration(double km);
}
