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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanTest1G extends JPanel implements ActionListener, KeyListener {

    private BufferedImage image;
    int velX = 320, velY = 750;
    int x = 320, y = 750;

    public PanTest1G() {
          // got this here: http://stackoverflow.com/questions/5921175/how-to-set-jpanels-width-and-height
       //setPreferredSize(new Dimension(500, 500));      //IMAGE IS SCALED TO FIT
      // setMaximumSize(new Dimension(500, 500));
        Timer t = new Timer(5, this);
        t.start();
       setFocusable(true);
        addKeyListener(this);
       //setDoubleBuffered(true);
        //setOpaque(false);
        try {
            image = ImageIO.read(new File("F5S4.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, 75, 100, null);
        

    }
@Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        x = velX;
       //y = velY;
    }

  @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
       /* if (code == KeyEvent.VK_UP) {
            velY += -2;
        }
        if (code == KeyEvent.VK_DOWN) {
            velY += 2;
        }*/
        if (code == KeyEvent.VK_LEFT) {
            velX -= 250;
        }
        if (code == KeyEvent.VK_RIGHT) {
            velX += 250;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
          
        }
        if (code == KeyEvent.VK_DOWN) {
            
        }
        if (code == KeyEvent.VK_LEFT) {
          
          
        }
        if (code == KeyEvent.VK_RIGHT) {
           
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
