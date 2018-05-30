package com.codecool.termlib;

import com.codecool.game.*;

import java.rmi.UnexpectedException;

public class GameLoop {
    
    
    
    public static void main(String[] args) {
        
        int[][] map = MapReader.mapReader();
        
        try {
            Player player = new Player(Coordinate.getPlayerCoordFromMap(map));
        } catch (UnexpectedException e) {
            System.out.print(e);
        }
        
        try {
            Terminal.setTerminalToRaw();
            
              /*//WHILE
                  // TODO: RESET
                  // TODO: DRAWING
                  // TODO: INPUT HANDLING
                  // TODO: TIMER
                  */
            boolean endGame = false;
            
            Terminal.clearScreen();
            Terminal.drawWholeArray(map);
            
            while (!endGame) {
                
                Thread.sleep(64);
            }
            
            Terminal.setTerminalToDefault();
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
    }
    
}
