package com.sondaAPI;

import com.sondaAPI.domain.Planet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetTest {

    @Test
    public void createPlanet() {
        Planet planet = new Planet(1L, "Jupiter" );
        assertEquals(1L, planet.getId());
        assertEquals("Jupiter", planet.getName());
    }

    @Test
    public void createPlanet2() {
        Planet planet = new Planet(2L, "Mars" );
        assertEquals(2L, planet.getId());
        assertEquals("Mars", planet.getName());
    }
}
