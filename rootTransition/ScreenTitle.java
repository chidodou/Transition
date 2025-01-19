import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ScreenTitle {

    // generate all components to create the full screen when starting the game
    public static void generateScreen() {
        clickableGeneratePlayButton();
        clickableGenerateSettingsButton();
        generateTitle();
    }

    // Play button that will go straight to a song in the first ver for testing
    public static void clickableGeneratePlayButton() {
        Generate.clickable(575,450,200,200);
    }

    public static void clickableGenerateSettingsButton() {
        Generate.clickable(625,50,100,100);
    }
    // generates middle title text (& testing border) for title screen
    public static void generateTitle() {
        Game.window.setLayout(null);
        JLabel label = new JLabel("Transition");
        label.setFont(new Font("Serif", Font.BOLD, 64));  // Font: Serif, Style: Bold, Size: 24
        label.setBounds(525, 275, 300, 100);  // x=100, y=50, width=200, height=30

        // shows the full border of the title
        Border titleBorder = BorderFactory.createLineBorder(Color.RED, 2);
        label.setBorder(titleBorder);
        Game.window.add(label);
    }

}
