package com.codecool.termlib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


 class Terminal {

    public static void drawWholeArray(int[][] map) {

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                moveCursorTo(y + 1, x + 1);

                switch (map[y][x]) {
                    case 2:
                        System.out.print("║");
                        break;
                    case 3:
                        System.out.print("═");
                        break;
                    case 4:
                        System.out.print("╔");
                        break;
                    case 5:
                        System.out.print("╗");
                        break;
                    case 6:
                        System.out.print("╚");
                        break;
                    case 7:
                        System.out.print("╝");
                        break;
                    case 8:
                        System.out.print("╠");
                        break;
                    case 9:
                        System.out.print("╣");
                        break;
                    case 10:
                        System.out.print("╦");
                        break;
                    case 11:
                        System.out.print("╩");
                        break;
                    case 12:
                        System.out.print("╬");
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
    private static void stty(final String args)
            throws IOException, InterruptedException {
        String cmd = "stty " + args + " < /dev/tty";

        exec(new String[]{
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

        return new String(bout.toByteArray());
    }

    public static void moveCursorTo(Integer y, Integer x) {
        System.out.print(String.format("\033[%s;%sf", y, x));
    }

    static void runTerminalCommand(TerminalCommands command) throws IOException, InterruptedException {
        switch (command) {
            case COLOR_BG_WHITE:
                System.out.print("\033[47m");
                break;
            case COLOR_BG_BLACK:
                System.out.print("\033[40m");
                break;
            case HIDE_CURSOR:
                System.out.print("\033[?25l");
                break;
            case SHOW_CURSOR:
                System.out.print("\033[?25h");
                break;
            case SET_TERMINAL_DEFAULT:
                stty("cooked echo");
                break;
            case SET_TERMINAL_RAW:
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
            case COLOR_BG_DEFAULT:
                System.out.print("\033[49m");
                break;
            case COLOR_FG_DEFAULT:
                System.out.print("\033[39m");
                break;
        }
    }
}
