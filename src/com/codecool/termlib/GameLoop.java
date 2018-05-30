package com.codecool.termlib;

import com.codecool.game.*;

import java.rmi.UnexpectedException;

public class GameLoop {

    // Mezi run cmd
    // " java -classpath /mnt/e/CC/OOP/terminal-library/out/production/terminal-library/com/codecool/termlib/GameLoop "

    public static void main(String[] args) {

        int[][] map = MapReader.mapReader();
        Player player;
        try {
            player = new Player(Coordinate.getPlayerCoordFromMap(map));
        } catch (UnexpectedException e) {
            System.out.print(e);
            player = new Player(new Coordinate(1, 1));
        }

        try {
             /*//WHILE
                  // TODO: RESET
                  // TODO: DRAWING
                  // TODO: INPUT HANDLING
                  // TODO: TIMER
                  */
            boolean endGame = false;

            Terminal.runTerminalCommand(TerminalCommands.SET_TERMINAL_RAW);
            Terminal.runTerminalCommand(TerminalCommands.HIDE_CURSOR);
            Terminal.runTerminalCommand(TerminalCommands.CLEAR_TERMINAL);
            Terminal.drawWholeArray(map);

            while (!endGame) {
                Terminal.drawWholeArray(map);
                player.drawPlayer();
                Thread.sleep(64);
            }

            Terminal.runTerminalCommand(TerminalCommands.SET_TERMINAL_DEFAULT);
            Terminal.runTerminalCommand(TerminalCommands.SHOW_CURSOR);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
