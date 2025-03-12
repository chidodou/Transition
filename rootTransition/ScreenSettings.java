import javax.swing.*;

public class ScreenSettings {
    public static void generateScreen() {
        JLabel gameLabel = new JLabel("Settings started!");
        gameLabel.setBounds(300, 200, 200, 50);
        Window.window.add(gameLabel);
        clickableGenerateBackButton();

        Window.window.revalidate(); // calls container from Window.window
        Window.window.repaint();

    }

    public static void clickableGenerateBackButton() {
        JButton backButton = Generate.clickable(1100, 600, 50, 50);

        backButton.addActionListener(e -> {
            Window.window.getContentPane().removeAll();
            Window.window.repaint();
            ScreenTitle.generateScreen();
        });
        ImageIcon icon = new ImageIcon("backarrow.png");
        backButton.setIcon(icon);
    }
}
