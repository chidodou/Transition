// TODO: switch window to lightweight java game library (lwjgl); may need a total rework?


import javax.swing.*;
import java.awt.*;
import java.awt.Container;

/*
Defines the window, which runs in class Start
 */

class Window {
    static JFrame window = new JFrame("Transition");

    // I want to add all other methods here for organization & efficiency
    public void start() {
        Container container = window.getContentPane();
        window.setSize(1366, 768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        container.setBackground(Color.lightGray);
        ScreenTitle.generateScreen();
        Window.window.setVisible(true);
        window.setBackground(Color.RED);
        //GraphicsEnvironmentGetter.getFonts();
    }
}