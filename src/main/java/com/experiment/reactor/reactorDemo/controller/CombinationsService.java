package com.experiment.reactor.reactorDemo.controller;

import com.experiment.reactor.reactorDemo.controller.request.OptionsRequest;
import com.experiment.reactor.reactorDemo.controller.response.CombinationsResponse;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static reactor.core.scheduler.Schedulers.parallel;

@Service
public class CombinationsService {

    @Autowired
    private StringConcatenationClient client;

    public Mono<CombinationsResponse> getCombinationsResponse(final OptionsRequest request) {
        return Flux.fromIterable(generateAllCombinationRequests(request))
                .parallel()
                .runOn(parallel())
                .flatMap(client::getAsyncResult)
                .sequential()
                .collectList()
                .map(this::aggregateCombinations);
    }

    private List<Pair<String, String>> generateAllCombinationRequests(final OptionsRequest request)
    {
        final List<String> firstList = request.getFirstEnumeration();
        final List<String> secondList = request.getSecondEnumeration();

        final Function<String, Stream<Pair<String, String>>> mapToPairWithFixedFirstItem =
                first -> secondList
                        .stream()
                        .map(second -> Pair.with(first, second));

        return firstList
                .stream()
                .flatMap(mapToPairWithFixedFirstItem)
                .toList();
    }

    private CombinationsResponse aggregateCombinations(final List<String> responses) {
        return CombinationsResponse.builder()
                .combinations(
                        responses.stream().sorted().toList()
                )
                .build();
    }
}
