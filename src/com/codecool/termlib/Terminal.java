package com.codecool.termlib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Terminal {
    
    private static String ttyConfig;
    
    /*public static void main(String[] args) {
        
        try {
            setTerminalToRaw();
            
            int i = 0;
            while (i < 30000) {
                
                //System.out.println( ""+ i++ );
                
                if (System.in.available() != 0) {
                    int c = System.in.read();
                    if (c == '0') {
                        System.out.println("You hit 0");
                        break;
                    } else if (c == 'w') {
                        System.out.println("w");
                    } else if (c == 'a') {
                        System.out.println("a");
                    } else if (c == 's') {
                        System.out.println("s");
                    } else if (c == 'd') {
                        System.out.println("d");
                    }
                }
                
                
            } // end while
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (InterruptedException e) {
            System.err.println("InterruptedException");
        } finally {
            try {
                stty(ttyConfig.trim());
            } catch (Exception e) {
                System.err.println("Exception restoring tty config");
            }
        }
        
    }
    */
    public static void setTerminalToRaw() throws IOException, InterruptedException {
        
        ttyConfig = stty("-g");
        
        // set the console to be character-buffered instead of line-buffered
        stty("-icanon min 1");
        
        // disable character echoing
        stty("-echo");
    }
    
    
    public static void initScreen(int[][] map) {
        Terminal.clearScreen();
        
        for(int y=0;y<map.length;y++){
            for(int x=0;x<map[y].length;x++){
                moveTo(y+1,x+1);
                
                System.out.print(map[y][x]);
            }
            
        }
        
        
        
    }
    
    /**
     * Execute the stty command with the specified arguments
     * against the current active terminal.
     */
    private static String stty(final String args)
            throws IOException, InterruptedException {
        String cmd = "stty " + args + " < /dev/tty";
        
        return exec(new String[]{
                "sh",
                "-c",
                cmd
        });
    }
    
    /**
     * Execute the specified command and return the output
     * (both stdout and stderr).
     */
    private static String exec(final String[] cmd)
            throws IOException, InterruptedException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        
        Process p = Runtime.getRuntime().exec(cmd);
        int c;
        InputStream in = p.getInputStream();
        
        while ((c = in.read()) != -1) {
            bout.write(c);
        }
        
        in = p.getErrorStream();
        
        while ((c = in.read()) != -1) {
            bout.write(c);
        }
        
        p.waitFor();
        
        String result = new String(bout.toByteArray());
        return result;
    }
    
    
    /**
     * Reset printing rules in effect to terminal defaults.
     * <p>
     * Reset the color, background color, and any other style
     * (i.e.: underlined, dim, bright) to the terminal defaults.
     */
    public void resetStyle() {
    }
    
    /**
     * Clear the whole screen.
     * <p>
     * Might reset cursor position.
     */
    public static void clearScreen() {
        System.out.print("\033[0;0f\033[J");
    }
    
 
    public static void moveTo(Integer x, Integer y) {
        System.out.print(String.format("\033[%s;%sf", x, y));
    }
    
 
    public static String setColor(Color color) {
        String colorStr = "";
        if (color == Color.BLACK) {
            colorStr = "\033[30mBlack";
        } else if (color == Color.RED) {
            colorStr = "\033[31mRed";
        } else if (color == Color.GREEN) {
            colorStr = "\033[32mGreen";
        } else if (color == Color.YELLOW) {
            colorStr = "\033[33mYellow";
        } else if (color == Color.BLUE) {
            colorStr = "\033[34mBlue";
        } else if (color == Color.MAGENTA) {
            colorStr = "\033[35mMagenta";
        } else if (color == Color.CYAN) {
            colorStr = "\033[36mCyan";
        } else if (color == Color.WHITE) {
            colorStr = "\033[97mWhite";
        } else {
            colorStr = "\033[97mWhite";
        }
        return colorStr;
    }
    
 
    public void setBgColor(Color color) {
    }
    
 
    
  
    public void moveCursor(Direction direction, Integer amount) {
        if (direction == Direction.FORWARD) {
            System.out.print(String.format("\033[%sC", amount));
        }
        if (direction == Direction.BACKWARD) {
            System.out.print(String.format("\033[%sD", amount));
        }
        if (direction == Direction.UP) {
            System.out.print(String.format("\033[%sA", amount));
        }
        if (direction == Direction.DOWN) {
            System.out.print(String.format("\033[%sB", amount));
        }
    }
    

    public void setChar(char c) {
        System.out.print(c); // TODO nem tudom mit kell csinálni
    }
    
  
    private void command(String commandString) {
    }
}
