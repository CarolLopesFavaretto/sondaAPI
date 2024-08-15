package com.sondaAPI.controller;

import com.sondaAPI.domain.Planet;
import com.sondaAPI.service.PlanetService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    Counter counterPlanet;

    public PlanetController(MeterRegistry registry) {
        counterPlanet = Counter.builder("planet.created")
                .description("Total de planetas criados")
                .register(registry);
    }

    @Autowired
    private PlanetService service;


    @PostMapping
    public Planet create (Planet planet) {
        counterPlanet.increment();
        return service.createPlanet(planet);
    }
}
