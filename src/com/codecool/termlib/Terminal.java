package com.codecool.termlib;


public class Terminal {
    /**
     * The beginning of control sequences.
     */
    private static final String CONTROL_CODE = "\033[";
    /**
     * Command for whole screen clearing.
     * <p>
     * Might be partitioned if needed.
     */
    private static final String CLEAR = "2J";
    /**
     * Command for moving the cursor.
     */
    private static final String MOVE = "H";
    /**
     * Command for printing style settings.
     * <p>
     * Handles foreground color, background color, and any other
     * styles, for example color brightness, or underlines.
     */
    private static final String STYLE = "m";

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
    public void clearScreen() {
        System.out.print("\033[0;0f\033[J");
    }

    /**
     * Move cursor to the given position.
     * <p>
     * Positions are counted from one.  Cursor position 1,1 is at
     * the top left corner of the screen.
     *
     * @param x Column number.
     * @param y Row number.
     */
    public void moveTo(Integer x, Integer y) {
        System.out.print(String.format("\033[%s;%sf", x, y));
    }

    /**
     * Set the foreground printing color.
     * <p>
     * Already printed text is not affected.
     *
     * @param color The color to set.
     */
    public void setColor(Color color) {
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
    }

    /**
     * Set the background printing color.
     * <p>
     * Already printed text is not affected.
     *
     * @param color The background color to set.
     */
    public void setBgColor(Color color) {
    }

    /**
     * Make printed text underlined.
     * <p>
     * On some terminals this might produce slanted text instead of
     * underlined.  Cannot be turned off without turning off colors as
     * well.
     */
    public void setUnderline() {
    }

    /**
     * Move the cursor relatively.
     * <p>
     * Move the cursor amount from its current position in the given
     * direction.
     *
     * @param direction Step the cursor in this direction.
     * @param amount    Step the cursor this many times.
     */
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

    /**
     * Set the character diplayed under the current cursor position.
     * <p>
     * The actual cursor position after calling this method is the
     * same as beforehand.  This method is useful for drawing shapes
     * (for example frame borders) with cursor movement.
     *
     * @param c the literal character to set for the current cursor
     *          position.
     */
    public void setChar(char c) {
        System.out.print(c); // TODO nem tudom mit kell csinálni
    }

    /**
     * Helper function for sending commands to the terminal.
     * <p>
     * The common parts of different commands shall be assembled here.
     * The actual printing shall be handled from this command.
     *
     * @param commandString The unique part of a command sequence.
     */
    private void command(String commandString) {
    }
}
