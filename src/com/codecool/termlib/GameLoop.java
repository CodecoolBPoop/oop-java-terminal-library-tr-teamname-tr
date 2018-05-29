package com.codecool.termlib;

import com.codecool.game.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLoop {
    
    public static void main(String[] args) {
        try {
            Terminal.setTerminalToRaw();
    
            int[][] map = MapReader.mapReader();
            Terminal.initScreen(map);
            
            
              /*//WHILE
                  // TODO: RESET
                  // TODO: DRAWING
                  // TODO: INPUT HANDLING
                  // TODO: TIMER
                  */
              boolean endGame = false;
              
              /*while (!endGame) {
                  Terminal.clearScreen();
              }*/
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
    }
    
}
