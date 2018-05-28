package com.codecool.termlib;

public class Test {
    
    
    public static void main(String[] args) {
        while (true) {
            try {
                if (System.in.available() > 0) {
                    char keyChar = (char) System.in.read();
                    System.out.println(keyChar);
                    
                    // respond to key character
                }
            } catch (Exception e) {
            
            }
        }
    }
    
}
