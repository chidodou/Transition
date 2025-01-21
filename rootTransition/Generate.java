import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Generate {

    // generates a clickable area that may be set and customized
    // currently uses the painted border as a reference
    // will return an object of JButton
    public static JButton clickable(int x, int y, int w, int h) {
        JButton button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true); // show area for testing

        // text, not foreground & should not exist without text
        button.setForeground(Color.WHITE);
        button.setBounds(x,y,w,h);

        Game.window.add(button);
        return button; // now can be customized
    }
}
