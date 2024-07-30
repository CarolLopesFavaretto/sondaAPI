package com.sondaAPI.domain;

import com.sondaAPI.exceptions.DirectionNotFoundException;
import lombok.Getter;

@Getter
public enum Direction {

    N,
    E,
    W,
    S;


    public Direction turnLeft() {
        switch (this) {
            case N:
                return W;
            case W:
                return S;
            case S:
                return E;
            case E:
                return N;
        }
        throw new DirectionNotFoundException("Direction invalid");
    }

    public Direction turnRight() {
        switch (this) {
            case N:
                return E;
            case E:
                return S;
            case S:
                return W;
            case W:
                return N;
            default:
                throw new DirectionNotFoundException("Direction invalid");
        }
    }
}
