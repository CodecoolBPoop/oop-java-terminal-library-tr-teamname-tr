package com.codecool.termlib;

import java.rmi.UnexpectedException;

public class Coordinate {

    Coordinate(int posX, int posY) {
        this.xPos = posX;
        this.yPos = posY;
    }

    static boolean isColliding(int xCoord, int yCoord, int[][] map) {
        return (map[yCoord][xCoord] > 1);
        /*
         * 0: free space
         * 1: starting point for player
         * 2 & above: walls
         * */
    }

    int getxPos() {
        return xPos;
    }


    private int xPos;

    int getyPos() {
        return yPos;
    }

    void alterYPos(int amount) {
        this.yPos += amount;
    }

    void alterXPos(int amount) {
        this.xPos += amount;
    }

    private int yPos;

    static Coordinate getPlayerCoordFromMap(int[][] map) throws UnexpectedException {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 1) {
                    return new Coordinate(x, y);
                }
            }
        }
        throw new UnexpectedException("Missing position for player!!!!!!!!!");
    }
}
