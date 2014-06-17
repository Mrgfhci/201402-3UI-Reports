/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idontknowwhatimdoing;

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

public class PanCenter extends JPanel implements ActionListener, KeyListener{

    ImageIcon iiback = new ImageIcon(this.getClass().getResource("that thing that minecraft made and i copied.jpg"));
    Image img = iiback.getImage();
    ImageIcon iihero = new ImageIcon(this.getClass().getResource("eating-grass.png"));
    Image ihero = iihero.getImage();
    int x = 0, y = 0;  //THESE CAN BE CHANGED LATER
    int velX = 0, velY = 0;

    //Timer t = new Timer(5, this);
    // t.start();
    // addKeyListener(this);
    public PanCenter() {
        // got this here: http://stackoverflow.com/questions/5921175/how-to-set-jpanels-width-and-height
        setPreferredSize(new Dimension(500, 500));      //IMAGE IS SCALED TO FIT
        setMaximumSize(new Dimension(500, 500));
        Timer t = new Timer(5, this);
        t.start();
        setFocusable(true);
        //Timer t = new Timer(5, this);
        //t.start();
        //img.setFocusable(true);
        //Event e = new Event();
        addKeyListener(this);
       // img.addActionListener(this);
        //ActionListener listen = new ActionListener();
        //addActionListener(img);
        //Timer t = new Timer(5,img);
        // t.start();
        
        setDoubleBuffered(true);
        setOpaque(false);
        //setResizable( false );
        //repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        //setPreferredSize(size);
        //setMinimumSize(size);
        // setMaximumSize(size);
        setSize(size);
        g.drawImage(img, x, y, getWidth(), getHeight(), this);      //MOVING DRAWIMAGE DOWN HERE MAKES SO IMAGE IS DRAWN WITH ABOVE DIMENSIONS
        //Dimension size2 = new Dimension(ihero.getWidth(null), ihero.getHeight(null));
        //setSize(size2);
        g.drawImage(ihero, 199, 100, 200, 200, this);
        Graphics2D g2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    //class Event implements ActionListener, KeyListener {

        //   @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            x += velX;
            y += velY;
        }

        //   @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_UP) {
                if (velY == 0) {
                    velY += -2;
                }
                if (velY < 0) {
                    velY += 0;
                }
                if (velY > 0) {
                    velY += -4;
                }

                //velX = 0;
            }
            if (code == KeyEvent.VK_DOWN) {
                if (velY == 0) {
                    velY += 2;
                }
                if (velY < 0) {
                    velY += 4;
                }
                if (velY > 0) {
                    velY += 0;
                }

                //velX = 0;
            }
            if (code == KeyEvent.VK_LEFT) {
                if (velX == 0) {
                    velX -= 2;
                }
                if (velX > 0) {
                    velX -= 4;
                }
                if (velX < 0) {
                    velX -= 0;
                }
            //if (x < 0) {
                //   velY = 0;
                // velX = 0;     //BOUNDS CHECKING?
                //  }
                // else {
                //velY = 0;
                // velX = -2;
                //   }
            }
            if (code == KeyEvent.VK_RIGHT) {
                if (velX == 0) {
                    velX += 2;
                }
                if (velX < 0) {
                    velX += 4;
                }
                if (velX > 0) {
                    velX += 0;
                }
       //     if (x > 760) {
                //       velY = 0;
                //   velX = 0;
                //  }
                //     velY = 0;
                //   velX = 2;
            }
        }

        //   @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_UP) {
                velY = 0;
                //velX = 0;
            }
            if (code == KeyEvent.VK_DOWN) {
                velY = 0;
                // velX = 0;
            }
            if (code == KeyEvent.VK_LEFT) {
                //  velY = 0;
                velX = 0;
            }
            if (code == KeyEvent.VK_RIGHT) {
                //  velY = 0;
                velX = 0;
            }

        }

        // @Override
        public void keyTyped(KeyEvent e) {

        }
 //   }
}
