package com.udea.bankrules.controller;

import com.udea.bankrules.model.AirlineRequest;
import com.udea.bankrules.model.AirlineResponse;
import com.udea.bankrules.service.AirlineEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineEvaluationService airlineService;

    @PostMapping("/evaluate")
    public AirlineResponse evaluate(@RequestBody AirlineRequest request) {
        return airlineService.evaluateFlight(request);
    }
}

