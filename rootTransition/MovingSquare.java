import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingSquare extends JPanel implements KeyListener {

    private int x = 50;
    private int y = 50;
    private final int SQUARE_SIZE = 50;
    private final int MOVE_SPEED = 10;

    public MovingSquare() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    // Override the addNotify method to request focus once the component is added to the screen
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow(); // Request focus when the panel is added to the window
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                y -= MOVE_SPEED;
                break;
            case KeyEvent.VK_S:
                y += MOVE_SPEED;
                break;
            case KeyEvent.VK_A:
                x -= MOVE_SPEED;
                break;
            case KeyEvent.VK_D:
                x += MOVE_SPEED;
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}

