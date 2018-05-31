package com.codecool.termlib;

import com.codecool.game.*;

import java.io.*;
import java.rmi.UnexpectedException;

class GameLoop {
    
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
            boolean endGame = false;
            
            Terminal.runTerminalCommand(TerminalCommands.SET_TERMINAL_RAW);
            Terminal.runTerminalCommand(TerminalCommands.HIDE_CURSOR);
            String startText = "EPIC LABYRINTH";
            Terminal.toiletPrint(startText);
            Thread.sleep(1000);
            Terminal.runTerminalCommand(TerminalCommands.CLEAR_TERMINAL);
            Terminal.drawWholeArray(map);
            Terminal.moveCursorTo(player.getCoordinates().getxPos() + 1, player.getCoordinates().getyPos() + 1);
            Terminal.runTerminalCommand(TerminalCommands.SAVE_CURSOR_POSITION);
            player.drawPlayer();
            while (!endGame) {
                if (System.in.available() != 0) {
                    int c = System.in.read();
                    if (c == '0') {
                        System.out.println("Exited from game loop");
                        break;
                    } else if (c == 'w') {
                        player.move(Direction.UP, map);
                    } else if (c == 'a') {
                        player.move(Direction.LEFT, map);
                    } else if (c == 's') {
                        player.move(Direction.DOWN, map);
                    } else if (c == 'd') {
                        player.move(Direction.RIGHT, map);
                    }
                    
                }
                player.drawPlayer();
                if (Coordinate.isExit(player.getCoordinates().getxPos(), player.getCoordinates().getyPos(), map)) {
                    endGame = true;
                }
                Thread.sleep(64);
            }
            Terminal.runTerminalCommand(TerminalCommands.COLOR_BG_DEFAULT);
            Terminal.runTerminalCommand(TerminalCommands.CLEAR_TERMINAL);
            
            for (int i = 0; i < 3; ++i) {
                String endText = "YOU WIN";
                Terminal.toiletPrint(endText);
                Thread.sleep(500);
                Terminal.runTerminalCommand(TerminalCommands.CLEAR_TERMINAL);
                String endText2 = "PREORDER NOW ON STEAM";
                Terminal.toiletPrint(endText2);
                Thread.sleep(1000);
            }
            Terminal.runTerminalCommand(TerminalCommands.SET_TERMINAL_DEFAULT);
            Terminal.runTerminalCommand(TerminalCommands.SHOW_CURSOR);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
