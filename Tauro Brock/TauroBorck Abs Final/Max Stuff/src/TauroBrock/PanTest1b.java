package TauroBrock;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanTest1b extends JPanel {

    private BufferedImage image1, image2, image3;
    private int img1x = 350, img1y = 10, nNewX = 1, imgAraX = 350, nAraX = 1;
    private Timer timer1;

//Graphics2D g2 = image2.createGraphics();
    public PanTest1b() {
        timer1 = new Timer(1, updateTask1);
        timer1.start();
        try {
            image1 = ImageIO.read(new File("YOLOROCKZ.png"));
            image2 = ImageIO.read(new File("bg1.jpg"));
            image3 = ImageIO.read(new File("F5S4.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image2, 0, 0, 750, 900, null);
        g.drawImage(image3, imgAraX, 700, 150, 150, null);
        g.drawImage(image1, img1x, img1y, 150, 150, null);

        repaint();

    }
    ActionListener updateTask1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            img1y += 5;

            if (img1y == 900) {
                if (nNewX == nAraX) {
                    System.out.println("Kablamo");
                }
                nNewX = (int) (Math.random() * 3);
                nAraX = (int) (Math.random() * 3);
                img1y = -100;
                if (nNewX == 0) { //left
                    img1x = 50;
                } else if (nNewX == 1) { //center
                    img1x = 350;
                } else { //right
                    img1x = 575;
                }
                if (nAraX == 0) { //left
                    imgAraX = 50;
                } else if (nAraX == 1) { //center
                    imgAraX = 350;
                } else  { //right
                    imgAraX = 575;
                }

            }
        }
    };
    // Allocate a Timer to run updateTask's actionPerformed() after every delay msec
    //timer = new Timer(1000, updateTask).start();
}
