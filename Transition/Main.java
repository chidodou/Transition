import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Main {
    public static void main(String[] args) {
        TransitionGame transition = new TransitionGame();
        transition.start(); // start app
    }
}

class TransitionGame {
    static JFrame frame = new JFrame("Transition");
    public void start() { // I want to add all other methods here I think
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLabel label = new JLabel("Transition");
        label.setFont(new Font("Serif", Font.BOLD, 64));  // Font: Serif, Style: Bold, Size: 24
        label.setBounds(600, 300, 1366, 768);  // x=100, y=50, width=200, height=30
        Border titleBorder = BorderFactory.createLineBorder(Color.RED, 2);
        label.setBorder(titleBorder);
        frame.add(label);
        createPlayButton();
    }

    public static void createPlayButton() { // Play button that will go straight to a song in the first ver
        JButton button = new JButton("Play!");
        button.setPreferredSize(new Dimension(200, 50));
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Button Clicked!");
        });
        button.setBounds(600, 600, 200, 50);
        frame.add(button);
        frame.setVisible(true);
    }
}
