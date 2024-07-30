package com.sondaAPI;

import com.sondaAPI.domain.Direction;
import com.sondaAPI.domain.ProbeDirection;
import com.sondaAPI.exceptions.CommandNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProbeTest {

    @Test
    public void testInitialPositionAndDirection() {
        ProbeDirection direction = new ProbeDirection(1, 2, Direction.N);
        assertEquals(1, direction.getX());
        assertEquals(2, direction.getY());
        assertEquals(Direction.N, direction.getDirection());
    }

    @Test
    public void testTurnLeft() {
        ProbeDirection direction = new ProbeDirection(0, 0, Direction.N);
        direction.executeCommands(List.of("L"));
        assertEquals(Direction.W, direction.getDirection());
    }

    @Test
    public void testTurnRight() {
        ProbeDirection direction = new ProbeDirection(0, 0, Direction.N);
        direction.executeCommands(List.of("R"));
        assertEquals(Direction.E, direction.getDirection());
    }

    @Test
    public void testMoveWithinBounds() {
        ProbeDirection direction = new ProbeDirection(0, 0, Direction.E);
        direction.executeCommands(List.of("M"));
        assertEquals(1, direction.getX());
        assertEquals(0, direction.getY());

        direction.executeCommands(List.of("M", "M", "M", "M"));
        assertEquals(4, direction.getX()); // Should be at the maximum X boundary
        assertEquals(0, direction.getY());
    }

    @Test
    public void testMoveOutOfBounds() {
        ProbeDirection direction = new ProbeDirection(0, 0, Direction.S);
        direction.executeCommands(List.of("M"));
        assertEquals(0, direction.getX());
        assertEquals(0, direction.getY()); // Should not move out of bounds

        direction.executeCommands(List.of("R", "R", "M", "M", "M", "M", "M"));
        assertEquals(0, direction.getX());
        assertEquals(4, direction.getY()); // Should be at the maximum Y boundary
    }

    @Test
    public void testComplexMovement() {
        ProbeDirection direction = new ProbeDirection(1, 2, Direction.N);
        direction.executeCommands(List.of("L", "M", "L", "M", "L", "M", "L", "M", "M"));
        assertEquals(1, direction.getX());
        assertEquals(3, direction.getY());
        assertEquals(Direction.N, direction.getDirection());

        ProbeDirection probeDirection = new ProbeDirection(3, 3, Direction.E);
        probeDirection.executeCommands(List.of("M", "M", "R", "M", "M", "R", "M", "R", "R", "M"));
        assertEquals(4, probeDirection.getX());
        assertEquals(1, probeDirection.getY());
        assertEquals(Direction.E, probeDirection.getDirection());
    }

    @Test
    public void testInvalidCommand() {
        ProbeDirection direction = new ProbeDirection(0, 0, Direction.N);
        Exception exception = assertThrows(CommandNotFoundException.class, () -> {
            direction.executeCommands(List.of("X"));
        });

        String expectedMessage = "Command invalid: X";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}


