import javax.swing.*;
import java.awt.*;
public class Generate {

    // generates a clickable area that may be set and customized
    // currently uses the painted border as a reference
    public static void clickable(int x, int y, int w, int h) {
        JButton button = new JButton();

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true); // show area for testing

        // text, not foreground & should not exist without text
        button.setForeground(Color.WHITE);

        button.addActionListener(e -> // study this method later
                JOptionPane.showMessageDialog
                        (null, "Button Clicked!"));
        button.setBounds(x,y,w,h);

        Game.window.add(button);
    }


    //TODO
    public void clicked() {

    }

    public static void screenClear() {
        JPanel clear = new JPanel();
        clear.repaint();
    }
}
