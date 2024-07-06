package com.experiment.reactor.reactorDemo.controller;

import org.javatuples.Pair;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class StringConcatenationClient {

    public Mono<String> getAsyncResult(final Pair<String, String> pair) {
        System.out.printf("%s - %s - %s - %s%n", pair.getValue0(), pair.getValue1(), LocalDateTime.now(), Thread.currentThread());
        return Mono.just(String.format("%s-%s", pair.getValue0(), pair.getValue1()));
    }
}
