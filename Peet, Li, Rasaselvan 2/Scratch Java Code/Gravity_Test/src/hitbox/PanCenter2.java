package hitbox;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class PanCenter2 extends JPanel implements ActionListener, KeyListener {

    double x = 50, y = 200, x2 = 350, y2 = 204;
    int nSize = 10, nSize2 = 10, nCount = 0, nGrav = 2;
    double velX = 0, velY = 0, nX = 0, nY = 0;
    boolean bPressed;

    public PanCenter2() {
        Timer t = new Timer(2, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setDoubleBuffered(true);

    }

    // Circle Black
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape circle = new Ellipse2D.Double(x, y, 40, 40);
        g2.setColor(Color.BLACK);
        g2.fill(circle);
    }

    //Other Graphics---------------------------------------------------------------
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape circle2 = new Rectangle2D.Double(x2, y2, nSize, nSize2);//circle blue 
        g2.setColor(Color.BLUE);
        g2.fill(circle2);

        Shape Rect = new Rectangle2D.Double(-10, 240, 600, 900);//Ground
        g2.setColor(Color.GREEN);
        g2.fill(Rect);
    }
    //----------Ground----------------------------------------------------------

    //--------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        // lines 49-51 gravity code from http://www.2oi.sgrondin.ca/ss15/motion.html
        nGrav+=1;
        velY += nGrav;
        x += velX;
        y += velY;
        x2 -= 2;
        if (velY>0){
            velY -= 1; 
        }
        if (velY<0){
            velY+=1;
        }
        if (nCount == 10) {
            nSize = 10;
            nSize2 = 10;
            nCount = 0;
        }

        if (x2 <= (-20)) {// reset blue ball
            x2 = 600;

        }
        if (y >= 200) {// Ground
            y = 200;
            nGrav=2;
            bPressed=false;
        }

        if (x <= (x2 + nSize) && y <= (y2 + nSize2) && x2 <= (x + 20) && y2 <= (y + 20)) {
            System.out.println("HIT!");
            x2 = 600;
            nCount += 1;
            nSize += 10;
            nSize2 += 10;
            //y2 = (int)(Math.random()*500) + 1;
            System.out.println("x: " + nCount);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP&&bPressed==false) {
            velY = -50;
            bPressed=true;
        }
        if (code == KeyEvent.VK_LEFT) {
            if (x < 0) {
                velX = 0;
            } else {
                velX = -15;
            }
        }
        if (code == KeyEvent.VK_RIGHT) {
            if (x > 760) {
                velX = 0;
            }
            velX = 15;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            velY +=1;
        }
        if (code == KeyEvent.VK_DOWN) {
            velY = 0;
        }
        if (code == KeyEvent.VK_LEFT) {
            velX = 0;
        }
        if (code == KeyEvent.VK_RIGHT) {
            velX = 0;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
