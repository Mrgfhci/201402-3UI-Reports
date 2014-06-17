package TauroBrock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PanTest1 extends JPanel {

    private BufferedImage image;
    private int imgx = 320, imgy = 750;
    Timer timer;

//Graphics2D g2 = image2.createGraphics();
    public PanTest1() {
        timer = new Timer(100, updateTask);
        timer.start();
        try {
            image = ImageIO.read(new File("F5S4.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(image, imgx, imgy, 75, 100 , null);
        repaint();
    }

    
    ActionListener updateTask = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
           
            
        }
    };
    
    
    
    
    
}
