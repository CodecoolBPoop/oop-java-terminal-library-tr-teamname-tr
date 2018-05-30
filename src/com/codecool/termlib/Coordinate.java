package com.codecool.termlib;

import java.rmi.UnexpectedException;

public class Coordinate {
    
    public Coordinate(int posX, int posY) {
        this.xPos = posX;
        this.yPos = posY;
    }
    
    
    public int getxPos() {
        return xPos;
    }
    
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
    
    private int xPos;
    
    public int getyPos() {
        return yPos;
    }
    
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    
    public void alterYPos(int amount) {
        this.yPos += amount;
    }
    
    public void alterXPos(int amount) {
        this.xPos += amount;
    }
    
    private int yPos;
    
    public static Coordinate getPlayerCoordFromMap(int[][] map) throws UnexpectedException {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 2) {
                    return new Coordinate(x, y);
                }
            }
            
        }
        throw new UnexpectedException("Missing position for player!!!!!!!!!");
    }
}
