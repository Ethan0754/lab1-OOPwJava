package Lab1;

import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Register"); //create initial window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterPanel panel = new RegisterPanel();//create a register panel that adds the panel and handles the logic
        panel.setPreferredSize(new Dimension(1920, 1080));

        frame.getContentPane().add(panel);
        frame.pack();

        frame.setVisible(true);

    }
}
