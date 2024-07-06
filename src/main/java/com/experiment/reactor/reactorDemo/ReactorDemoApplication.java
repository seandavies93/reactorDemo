package com.experiment.reactor.reactorDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class ReactorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactorDemoApplication.class, args);
	}

}
