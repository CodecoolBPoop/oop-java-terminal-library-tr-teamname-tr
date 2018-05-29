import com.sun.glass.events.KeyEvent;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        System.out.print("\033?1047h");
        System.out.print("\033[0;0f\033[J");
        //  System.out.print("\033[5;5f" + "Hello World!");

        java.io.InputStreamReader reader = new java.io.InputStreamReader(System.in);
        boolean b = false;
        while(!b)
        {
            try
            {
                int key = System.in.read();
                // read a character and process it
                System.out.println("key pressed");
                b = true;
            } catch (java.io.IOException ioex) {
                System.out.println("IO Exception");
            }
            // edit, lets not hog any cpu time
            try {
                Thread.sleep(50);
                System.out.println("nop yet");
            } catch (InterruptedException ex) {
                // can't do much about it can we? Ignoring
                System.out.println("Interrupted Exception");
            }
        }


            //do something
        }
/*
            in.close();
            f.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(java.awt.event.KeyEvent e) {

                }

                @Override
                public void keyPressed(java.awt.event.KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    switch( keyCode ) {
                        case KeyEvent.VK_UP:
                            System.out.print("\033[5;5f" + "Hello World!");
                            break;
                        case KeyEvent.VK_DOWN:
                            // handle down
                            break;
                        case KeyEvent.VK_LEFT:
                            // handle left
                            break;
                        case KeyEvent.VK_RIGHT :
                            // handle right
                            break;
                    }
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent e) {

                }
            });
            */
    }

