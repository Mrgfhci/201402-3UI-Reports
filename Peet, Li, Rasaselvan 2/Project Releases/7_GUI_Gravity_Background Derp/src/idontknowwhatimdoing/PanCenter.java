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
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanCenter extends JPanel implements ActionListener, KeyListener{

    ImageIcon iiback = new ImageIcon(this.getClass().getResource("backgroundjavagame-01.jpg"));
    Image img = iiback.getImage();
    ImageIcon iihero = new ImageIcon(this.getClass().getResource("eating-grass.png"));
    Image ihero = iihero.getImage();
    int x = 0, y = 0;  //THESE CAN BE CHANGED LATER
    int velX = 0, velY = 0, i = 0, nGrav = 0;
    boolean bPressed;
    //Timer t = new Timer(5, this);
    // t.start();
    // addKeyListener(this);
    public PanCenter() {
        // got this here: http://stackoverflow.com/questions/5921175/how-to-set-jpanels-width-and-height
        setPreferredSize(new Dimension(800, 600));      //IMAGE IS SCALED TO FIT
        setMaximumSize(new Dimension(800, 600));
        Timer t = new Timer(30, this);
        t.start();
        setFocusable(true);
        addKeyListener(this);   
        setDoubleBuffered(true);
        setOpaque(false);
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
        g.drawImage(img, x, y-1277, getWidth(), getHeight(), this);      //MOVING DRAWIMAGE DOWN HERE MAKES SO IMAGE IS DRAWN WITH ABOVE DIMENSIONS
        //Dimension size2 = new Dimension(ihero.getWidth(null), ihero.getHeight(null));
        //setSize(size2);
        g.drawImage(ihero, 199, 283, 200, 200, this);
        
        Graphics2D g2d = (Graphics2D) g;
        
        //int nWid = Rect2.
        Shape Rect = new Rectangle2D.Double(x, y+440, 45000, 10);//Ground
        //g2d.setColor(Color.GREEN);
        g2d.fill(Rect);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    //class Event implements ActionListener, KeyListener {
        
           @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            if (nGrav<5){
                nGrav+=1;
            }
            velY-=nGrav;
            x += velX;              //FIXED RUEBAN'S CODE, TAKEN FROM:http://www.2oi.sgrondin.ca/ss15/motion.html
            y += velY;
            if (y < 42){           //CURRENTLY HARDCODE, IF WE WANT MULTIPLE LEVELS, WE NEED TO FIX THIS
                nGrav = 0;      //STILL FULL OF BUGS... NEED TO FIX
                velY = 0;
                bPressed = false;
                

            }
            Shape Rect2 = new Rectangle2D.Double(199,283,200,200);
            Shape Rect = new Rectangle2D.Double(x, y+440,45000, 10);
            //int i = 0;
            if (Rect.intersects((Rectangle2D) Rect2)){          //HIT DETECTION IDEAS TAKEN FROM http://stackoverflow.com/questions/335600/collision-detection-between-two-images-in-java
                i+=1;
                System.out.println("Collision number: " +i);
                System.out.println(y);
                y = 42;
                velY = 0;
                nGrav = 0;
            }
            //if (199 <= (x + 200) && 283 >= (y + 200) && x <= (199 + 20) && y >= (283 + 20)) {     //WEIHAN'S HITTEST
           // System.out.println("HIT!");
           // velX = 0;
           // velY = 0;
         //   x = 600;
          //  nCount += 1;
           // nSize += 10;
            //nSize2 += 10;
            //y2 = (int)(Math.random()*500) + 1;
         //   System.out.println("x: " + nCount);
       // }
           }
           @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_SPACE&& bPressed == false ) {
                bPressed = true;
                if (velY == 0) {
                    velY += 50;
                }
                if (velY < 0) {
                    velY += 0;
                }
                if (velY > 0) {
                    velY += 4;
                }
                //velX = 0;
            }
     /*       if (code == KeyEvent.VK_DOWN) {
                if (velY == 0) {
                    velY += -2;
                }
                if (velY < 0) {
                    velY += -4;
                }                                       //DON'T NEED DOWN KEY ANYMORE   
                if (velY > 0) {
                    velY += 0;
                }

                //velX = 0;
            }*/
            if (code == KeyEvent.VK_A) {
                if (velX == 0) {
                    velX += 2;
                }
                if (velX > 0) {
                    velX += 4;
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
            if (code == KeyEvent.VK_D) {
                if (velX == 0) {
                    velX -= 2;
                }
                if (velX < 0) {
                    velX -= 4;
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

           @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_SPACE) {
                velY = 0;
                //velX = 0;
            }
            if (code == KeyEvent.VK_DOWN) {
                velY = 0;
                // velX = 0;
            }
            if (code == KeyEvent.VK_A) {
                //  velY = 0;
                velX = 0;
            }
            if (code == KeyEvent.VK_D) {
                //  velY = 0;
                velX = 0;
            }

        }

         @Override
        public void keyTyped(KeyEvent e) {

        }
 //   }
}
