package com.udea.bankrules.service;

import com.udea.bankrules.model.AirlineRequest;
import com.udea.bankrules.model.AirlineResponse;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineEvaluationService {

    @Autowired
    private KieContainer kieContainer;

    public AirlineResponse evaluateFlight(AirlineRequest request) {
        AirlineResponse response = new AirlineResponse();
        KieSession kieSession = kieContainer.newKieSession();
        try {
            kieSession.insert(request);
            kieSession.insert(response);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
        return response;
    }
}


