package com.codecool.termlib;

class Player {
    //Constructor
    Player(Coordinate coords) {
        this.coordinates = coords;
    }

    Coordinate getCoordinates() {
        return coordinates;
    }

    private Coordinate coordinates;


    void drawPlayer() {
        try {

            Terminal.runTerminalCommand(TerminalCommands.RESTORE_CURSOR_POSITION);
            Terminal.runTerminalCommand(TerminalCommands.COLOR_BLACK);
            System.out.print(" ");
            Terminal.moveCursorTo(this.coordinates.getyPos() + 1, this.coordinates.getxPos() + 1);
            Terminal.runTerminalCommand(TerminalCommands.COLOR_WHITE);
            Terminal.runTerminalCommand(TerminalCommands.SAVE_CURSOR_POSITION);
            System.out.print("*");

        } catch (Exception e) {
            System.out.print(e);
        }

    }

    void move(Direction direction, int[][] map) {
        int pX = this.coordinates.getxPos();
        int pY = this.coordinates.getyPos();
        switch (direction) {
            case UP:
                if (!Coordinate.isColliding(pX, --pY, map)) {
                    coordinates.alterYPos(-1);
                }
                break;

            case DOWN:
                if (!Coordinate.isColliding(pX, ++pY, map)) {
                    coordinates.alterYPos(1);
                }
                break;

            case RIGHT:
                if (!Coordinate.isColliding(++pX, pY, map)) {
                    coordinates.alterXPos(1);
                }
                break;

            case LEFT:
                if (!Coordinate.isColliding(--pX, pY, map)) {
                    coordinates.alterXPos(-1);
                }
                break;
        }
    }
}
