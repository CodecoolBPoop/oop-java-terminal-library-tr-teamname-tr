package com.codecool.termlib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


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


    public static void drawWholeArray(int[][] map) {

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                moveCursorTo(y + 1, x + 1);

                switch (map[y][x]) {
                    case 1:
                        System.out.print("#");
                        break;

                    default:
                        System.out.print(" ");
                }

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


    public static void moveCursorTo(Integer y, Integer x) {
        System.out.print(String.format("\033[%s;%sf", y, x));
    }

    public void moveCursor(Direction direction, Integer amount) {
        if (direction == Direction.RIGHT) {
            System.out.print(String.format("\033[%sC", amount));
        }
        if (direction == Direction.LEFT) {
            System.out.print(String.format("\033[%sD", amount));
        }
        if (direction == Direction.UP) {
            System.out.print(String.format("\033[%sA", amount));
        }
        if (direction == Direction.DOWN) {
            System.out.print(String.format("\033[%sB", amount));
        }
    }

    static void runTerminalCommand(TerminalCommands command) throws IOException, InterruptedException {
        switch (command) {
            case COLOR_WHITE:
                System.out.print("\033[47m");
                break;
            case COLOR_BLACK:
                System.out.print("\033[40m");
                break;
            case HIDE_CURSOR:
                System.out.print("\033[?25l");
                break;
            case SHOW_CURSOR:
                System.out.print("\033[?25h");
                break;
            case SET_TERMINAL_DEFAULT:
                ttyConfig = stty("-g");
                stty("cooked echo");
                break;
            case SET_TERMINAL_RAW:
                ttyConfig = stty("-g");
                // set the console to be character-buffered instead of line-buffered
                stty("-icanon min 1");
                // disable character echoing
                stty("-echo");
                break;
            case CLEAR_TERMINAL:
                System.out.print("\033[0;0f\033[J");
                break;
            case SAVE_CURSOR_POSITION:
                System.out.print("\0337");
                break;
            case RESTORE_CURSOR_POSITION:
                System.out.print("\0338");
                break;
        }
    }
}
