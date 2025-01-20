package Lab1;

import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Registerho");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterPanel panel = new RegisterPanel();
        panel.setPreferredSize(new
                Dimension(500, 500));

        frame.getContentPane().add(panel);
        frame.pack();

        frame.setVisible(true);

    }
}
