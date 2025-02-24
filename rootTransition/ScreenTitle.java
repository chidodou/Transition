import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

 // TODO: "format" - button.addActionListener(event -> {});


public class ScreenTitle {

    // generate all components to create the full screen when starting the game
    public static void generateScreen() {
        clickableGeneratePlayButton();
        clickableGenerateSettingsButton();
        generateTitle();
    }

    // makes play button, ONLY WORKS WITH addActionListener()
    public static void clickableGeneratePlayButton() {
        JButton playButton = Generate.clickable(575, 450, 200, 200);

        playButton.addActionListener(e -> {
            Window.window.getContentPane().removeAll();
            Window.window.repaint();
            ScreenGame.generateScreen();
        });
    }

    public static void clickableGenerateSettingsButton() {
        JButton settingsButton = Generate.clickable(625,50,100,100);
        settingsButton.addActionListener(e -> {
            Window.window.getContentPane().removeAll();
            Window.window.repaint();
            ScreenSettings.generateScreen();
        });
    }

    // generates middle title text (& testing border) for title screen
    public static void generateTitle() {
        Window.window.setLayout(null);
        JLabel label = new JLabel("Transition");
        label.setFont(new Font("Serif", Font.BOLD, 64));  // Font: Serif, Style: Bold, Size: 24
        label.setBounds(525, 275, 300, 100);  // x=100, y=50, width=200, height=30

        Border titleBorder = BorderFactory.createLineBorder(Color.RED, 2);
        label.setBorder(titleBorder);
        Window.window.add(label);
    }

}
