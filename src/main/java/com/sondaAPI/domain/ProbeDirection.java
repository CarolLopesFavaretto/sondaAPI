package com.sondaAPI.domain;

import com.sondaAPI.exceptions.CommandNotFoundException;
import com.sondaAPI.exceptions.DirectionNotFoundException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProbeDirection {

    private Integer x;
    private Integer y;
    private Direction direction;

    private static final int MAX_X = 4;
    private static final int MAX_Y = 4;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    public ProbeDirection(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void executeCommands(List<String> commands) {
        for (String command : commands) {
            switch (command) {
                case "L":
                    turnLeft();
                    break;
                case "R":
                    turnRight();
                    break;
                case "M":
                    move();
                    break;
                default:
                    throw new CommandNotFoundException("Command invalid: " + command);
            }
        }
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void turnRight() {
        direction = direction.turnRight();
    }


    private void move() {
        if (canMove()) {
            switch (direction) {
                case N:
                    y++;
                    break;
                case E:
                    x++;
                    break;
                case S:
                    y--;
                    break;
                case W:
                    x--;
                    break;
                default:
                    throw new DirectionNotFoundException("Direction invalid: " + direction);
            }
        }
    }

    private boolean canMove() {
        switch (direction) {
            case N:
                return y < MAX_Y;
            case E:
                return x < MAX_X;
            case S:
                return y > MIN_Y;
            case W:
                return x > MIN_X;
            default:
                throw new DirectionNotFoundException("Direction invalid: " + direction);
        }
    }
}

