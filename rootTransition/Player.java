import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import javax.swing.*;


public class Player {
    Rectangle player = new Rectangle();
    static KeyListener detectKey;
    MouseListener detectMouse = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
    EventListener detectEvent = new EventListener() {
        @Override
        public int hashCode() { return super.hashCode(); }


    };
    ActionListener detectAction = e -> {

    };
    public static void move() {
        detectKey = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }
}
