package com.codecool.termlib;

public class GameLoop {
    
    public static void main(String[] args) {
        try {
            Terminal.setTerminalToRaw();
              
              /*//WHILE
                  // TODO: RESET
                  // TODO: DRAWING
                  // TODO: INPUT HANDLING
                  // TODO: TIMER
                  */
              boolean endGame = false;
              
              while (!endGame) {
                  Terminal.clearScreen();
              }
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
    }
    
}
