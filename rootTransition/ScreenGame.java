import javax.swing.*;

public class ScreenGame {
    // should go to the game screen initialized by Window;
    // Generate not needed
    public static void generateScreen() {
        JLabel gameLabel = new JLabel("Game started!");
        gameLabel.setBounds(300, 200, 200, 50);
        Window.window.add(gameLabel);
        clickableGenerateBackButton();

        Window.window.revalidate(); // calls container from Window.window
        Window.window.repaint();

    }

    public static void clickableGenerateBackButton() {
        JButton backButton = Generate.clickable(100, 50, 50, 50);

        backButton.addActionListener(e -> {
            Window.window.getContentPane().removeAll();
            Window.window.repaint();
            ScreenTitle.generateScreen();
        });
    }
}
