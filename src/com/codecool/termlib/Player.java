package com.codecool.termlib;

import java.lang.reflect.Array;
import java.rmi.UnexpectedException;

public class Player {
    
     Player(Coordinate coords) {
        this.coordinates = coords;
    }
    
    
    private Coordinate coordinates;
    
    
    
    
    public void move(Direction direction, int amount) {
        switch (direction) {
            case UP:
                coordinates.alterYPos(-1 * amount);
                break;
            
            case DOWN:
                coordinates.alterYPos(amount);
                break;
            
            case RIGHT:
                coordinates.alterXPos(-1 * amount);
                break;
            
            case LEFT:
                coordinates.alterXPos(amount);
                break;
        }
    }
    
    
}
