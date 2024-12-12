package com.train.app.api;

import com.train.app.model.dto.TravelResult;
import com.train.app.service.RaptorService;
import com.train.app.util.raptor.AllRoutesRaptorService;
import com.train.app.util.raptor.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/train-api/travel")
@RequiredArgsConstructor
public class RaptorController {

    private final AllRoutesRaptorService allRoutesRaptorService;
    private final RaptorService raptorService;

    @GetMapping("/findRoutes")
    public List<Path> findRoutes(@RequestParam int startStationId, @RequestParam int endStationId) {
        return allRoutesRaptorService.findAllRoutes(startStationId, endStationId);
    }

    @GetMapping("/findTravels")
    public List<List<TravelResult>> findTravels(@RequestParam int startStationId, @RequestParam int endStationId, @RequestParam LocalDate localDate) {
        return raptorService.searchForTravels(startStationId, endStationId, localDate, 0);
    }
}
