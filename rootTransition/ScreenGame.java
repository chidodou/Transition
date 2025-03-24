import javax.swing.*;

public class ScreenGame {

    public static void generateScreen() {
        // Remove all components from the window first
        Window.window.getContentPane().removeAll();

        // Create and add the MovingSquare JPanel to the window
        MovingSquare movingSquare = new MovingSquare();
        movingSquare.setBounds(0, 0, 800, 600); // Set bounds to fit the window size
        Window.window.add(movingSquare);

        clickableGenerateBackButton(); // Add back button

        // Request focus for MovingSquare to ensure key events work
        movingSquare.requestFocusInWindow();

        // Revalidate and repaint to reflect changes
        Window.window.revalidate();
        Window.window.repaint();
    }

    public static void clickableGenerateBackButton() {
        JButton backButton = Generate.clickable(100, 50, 50, 50);

        backButton.addActionListener(e -> {
            Window.window.getContentPane().removeAll();
            Window.window.repaint();
            ScreenTitle.generateScreen();
        });

        ImageIcon icon = new ImageIcon("backarrow.png");
        backButton.setIcon(icon);
        Window.window.add(backButton); // Add the back button to the window
    }
}
