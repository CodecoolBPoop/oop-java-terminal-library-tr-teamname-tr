package com.codecool.termlib;

import java.rmi.UnexpectedException;
import java.rmi.server.ExportException;

public class Player {
    //Constructor
    Player(Coordinate coords) {
        this.coordinates = coords;
    }


    public Coordinate getCoordinates() {
        return coordinates;
    }

    private Coordinate coordinates;


    void drawPlayer() {
        try {
            Terminal.runTerminalCommand(TerminalCommands.RESTORE_CURSOR_POSITION);
            Terminal.runTerminalCommand(TerminalCommands.COLOR_BLACK);
            System.out.print(" ");
            Terminal.moveCursorTo(this.coordinates.getyPos()+1, this.coordinates.getxPos()+1);
            Terminal.runTerminalCommand(TerminalCommands.COLOR_WHITE);
            Terminal.runTerminalCommand(TerminalCommands.SAVE_CURSOR_POSITION);
            System.out.print("*");
        } catch (Exception e) {
            System.out.print(e);
        }

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
                coordinates.alterXPos(amount);
                break;

            case LEFT:
                coordinates.alterXPos(-1 * amount);
                break;
        }
    }
}
