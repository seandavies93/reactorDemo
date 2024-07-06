package com.experiment.reactor.reactorDemo;

import com.experiment.reactor.reactorDemo.controller.request.OptionsRequest;
import com.experiment.reactor.reactorDemo.controller.response.CombinationsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class CombinationsApiTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testCombinationsResponse() {

        final OptionsRequest request = OptionsRequest.builder()
                .firstEnumeration(List.of("one", "two"))
                .secondEnumeration(List.of("month", "year"))
                .build();

        final CombinationsResponse response = CombinationsResponse.builder()
                .combinations(Stream.of("one-month", "one-year", "two-month", "two-year").sorted().toList())
                .build();

        webTestClient.post()
                .uri("/combinations/response")
                .bodyValue(request)
                .exchange()
                .expectBody(CombinationsResponse.class)
                .isEqualTo(response);
    }

}
