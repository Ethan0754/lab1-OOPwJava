package Lab1;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class PursePanel extends JPanel {
    public Purse purse;

    private BufferedImage image;


    PursePanel() {
        purse = new Purse();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        BufferedImage image = null;
        int stack = 0; //var used to move the bills across the x axis
        //for each map in the purse - display the correct amount of bills/coins and move the next image appropriately
        for (Map.Entry<Denomination, Integer> bills : purse.cash.entrySet()) {
            //read file
            try {
                image = ImageIO.read(new File(bills.getKey().img()));
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            int counter = 0;//var used for moving the bills across the y axis
            //for each bill in one mapping - display the correct number of that specifc bill/coin
            for (int i = 0; i < bills.getValue(); i++) {
                if (Objects.equals(bills.getKey().form(), "coin")){
                    drawScaledImage(g2d, image, stack, counter, 50, 50);
                    counter += 50;
                }
                else{
                    drawScaledImage(g2d, image, stack, counter, 150, 50);
                    counter +=25;
                }

            }
            if (Objects.equals(bills.getKey().form(), "coin")) {
                stack += 50;
            }
            else{
                stack += 150;
            }
        }



    }


    private void drawScaledImage(Graphics2D g2d, BufferedImage image, int x, int y, int width, int height) {
        AffineTransform at = new AffineTransform();
        at.translate(x, y);
        at.scale((double) width / image.getWidth(), (double) height / image.getHeight());
        g2d.drawRenderedImage(image, at);
    }



}
