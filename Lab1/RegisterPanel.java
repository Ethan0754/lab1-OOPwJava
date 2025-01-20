package Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register = new Register();

    private JPanel inputPanel;

    private JTextField input;

    private PursePanel changePanel;

    RegisterPanel() {

        this.setBackground(Color.BLUE);
        inputPanel.setBackground(Color.RED);
        inputPanel.setForeground(Color.WHITE);
        input.addActionListener(new InputListener());

        this.setPreferredSize(
                new Dimension(500, 500));

        this.add(inputPanel);
        this.add(changePanel);
    }




    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            register.makeChange(e)


        }
    }
}
