package com.codecool.termlib;

import com.codecool.game.*;

public class GameLoop {
    
    public static void main(String[] args) {
        try {
            Terminal.setTerminalToRaw();
            
            int[][] map = MapReader.mapReader();
            Terminal.draw(map);
            
            
              /*//WHILE
                  // TODO: RESET
                  // TODO: DRAWING
                  // TODO: INPUT HANDLING
                  // TODO: TIMER
                  */
            boolean endGame = false;
            
            
            Terminal.clearScreen();
            Terminal.draw(map);
            
            while (!endGame) {
                
                Thread.sleep(64);
            }
            
            Terminal.setTerminalToDefault();
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
    }
    
}
