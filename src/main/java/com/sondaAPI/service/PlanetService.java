package com.sondaAPI.service;

import com.sondaAPI.domain.Planet;
import com.sondaAPI.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository repository;

    public Planet createPlanet(Planet planet) {
        return repository.save(planet);
    }
}
