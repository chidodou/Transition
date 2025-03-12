import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
// TODO: add player as a square, can wasd, can do diagonal properly,
// TODO: add GOALS for the player
// format - new Thread(() -> {}).start();


public class Player implements KeyListener, MouseListener, EventListener, ActionListener {
    Rectangle player = new Rectangle();
    static KeyListener detectKey;
    private boolean doMoveUp = false;
    private boolean doMoveDown = false;
    private boolean doMoveLeft = false;
    private boolean doMoveRight = false;

    public void startMovement() {
        // A thread should be used to handle all movement
        new Thread(() -> {

            while (true) {
                if (doMoveUp) {
                }
                if (doMoveDown) {
                }
                if (doMoveLeft) {
                }
                if (doMoveRight) {
                }

                // Adjust the sleep time to control the speed of movement
                try { Thread.sleep(10); }
                catch (InterruptedException e) { e.printStackTrace(); }
            }
        }).start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

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

    // These further overrides only focus on key listening
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

