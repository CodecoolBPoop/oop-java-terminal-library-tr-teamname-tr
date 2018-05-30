package com.codecool.termlib;

public class Player {
    //Constructor
    Player(Coordinate coords) {
        this.coordinates = coords;
    }


    private Coordinate coordinates;

    void drawPlayer() {
        Terminal.moveCursorTo(this.coordinates.getxPos(), this.coordinates.getyPos());
        System.out.print("\033[47m");
        System.out.print("#");
        System.out.print("\033[40m");
    }

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
