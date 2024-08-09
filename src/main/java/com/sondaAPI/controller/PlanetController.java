package com.sondaAPI.controller;

import com.sondaAPI.domain.Planet;
import com.sondaAPI.service.PlanetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    private final PlanetService service;
    public PlanetController(PlanetService planetService) {
        this.service = planetService;
    }

    @PostMapping
    public Planet create (Planet planet) {
        return service.createPlanet(planet);
    }


}
