package com.experiment.reactor.reactorDemo.controller.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OptionsRequest {
    private List<String> firstEnumeration;
    private List<String> secondEnumeration;
}
