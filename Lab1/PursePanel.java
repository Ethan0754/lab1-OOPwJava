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
        int counter = 0;

        for (Map.Entry<Denomination, Integer> bills : purse.cash.entrySet()) {
            try {
                image = ImageIO.read(new File(bills.getKey().img()));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < bills.getValue(); i++) {
                drawScaledImage(g2d, image, 0, counter, 300, 100);
                counter += 50;
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
