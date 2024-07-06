package com.experiment.reactor.reactorDemo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Jacksonized
public class CombinationsResponse {
    private List<String> combinations;
}
