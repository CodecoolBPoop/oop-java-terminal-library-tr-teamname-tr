import com.sun.glass.events.KeyEvent;

import javax.swing.*;
import java.awt.event.KeyListener;


public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        System.out.print("\033?1047h");
        System.out.print("\033[0;0f\033[J");
      //  System.out.print("\033[5;5f" + "Hello World!");

        while (true){
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
        }



    }

}
