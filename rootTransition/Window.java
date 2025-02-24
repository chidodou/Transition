import org.lwjgl.opengl.*;
// TODO: switch window to opengl

import javax.swing.*;

/*
Defines the window, which runs in class Start
 */

class Window {
    static JFrame window = new JFrame("Transition");

    // I want to add all other methods here for organization & efficiency
    public void start() {
        window.setSize(1366, 768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        ScreenTitle.generateScreen();
        Window.window.setVisible(true);
        GraphicsEnvironmentGetter.getFonts();
    }
}