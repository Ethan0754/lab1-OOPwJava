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

        inputPanel = new JPanel();

        input = new JTextField();

        changePanel = new PursePanel();

        this.setBackground(Color.WHITE);
        inputPanel.setBackground(Color.BLACK);
        input.setBackground(Color.WHITE);
        inputPanel.setPreferredSize(new Dimension(100, 50));
        input.setPreferredSize(new Dimension(80, 40));

        changePanel.setPreferredSize(new Dimension(1000, 1000));

        //handles the input to the gui
        input.addActionListener(new InputListener());

        this.setBackground(Color.WHITE);


        this.add(inputPanel);
        inputPanel.add(input);
        this.add(changePanel);
    }




    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double num = Double.parseDouble(input.getText());
            String text = register.makeChange(num).toString();
            System.out.println(text);
            changePanel.purse = register.makeChange(num);
            changePanel.repaint();
        }
    }
}
