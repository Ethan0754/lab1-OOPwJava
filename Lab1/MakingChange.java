package Lab1;

import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterPanel panel = new RegisterPanel();
        panel.setPreferredSize(new
                Dimension(1920, 1080));

        frame.getContentPane().add(panel);
        frame.pack();

        frame.setVisible(true);

    }
}
