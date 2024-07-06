package com.experiment.reactor.reactorDemo.controller;

import com.experiment.reactor.reactorDemo.controller.request.OptionsRequest;
import com.experiment.reactor.reactorDemo.controller.response.CombinationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/combinations")
public class CombinationController {

    @Autowired
    private CombinationsService combinationsService;

    @PostMapping(value = "/response", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CombinationsResponse> getCombinationsResponse(@RequestBody final OptionsRequest request) {
        return combinationsService.getCombinationsResponse(request);
    }
}
