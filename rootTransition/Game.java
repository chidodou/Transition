import javax.swing.*;
import java.awt.GraphicsEnvironment;

class Game {
    static JFrame window = new JFrame("Transition");
    // I want to add all other methods here for organization & efficiency
    public void start() {
        window.setSize(1366, 768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ScreenTitle.generateScreen();

        Game.window.setVisible(true);
        GraphicsEnvironmentGetter.getFonts();
    }
}

/*
do not tamper unless you know what you are doing
obv a pretty dangerous class
 */