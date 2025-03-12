import javax.swing.*;
import java.awt.*;

/*
Creats all methods needed to commit to an action, such as a JButton "clickable"
 */

public class Generate {

    // generates a clickable area that may be set and customized
    // currently uses painted border as reference
    // will return an object of JButton
    public static JButton clickable(int x, int y, int w, int h) {
        JButton button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false); // show area for testing

        // text, not foreground & should not exist without text
        button.setForeground(Color.WHITE);
        button.setBounds(x,y,w,h);

        Window.window.add(button);
        return button; // now can be customized
    }
}
