package hitbox;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;


public class PanCenter2 extends JPanel implements ActionListener, KeyListener{     
    double x, y;
    double velX = 0, velY = 0;
     
    public PanCenter2() {
        Timer t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setDoubleBuffered(true);
    }
     
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape circle = new Ellipse2D.Double(x, y, 40, 40);
        g2.setColor(Color.BLUE);
        g2.fill(circle);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        x += velX;
        y += velY;
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            if (velY == 0){
                velY += -2;
            }
            if (velY<0){
                velY += 0;
            }
            if (velY>0){
                velY += -4;
            }
            
            //velX = 0;
        }
        if (code == KeyEvent.VK_DOWN) {
            if (velY == 0){
                velY += 2;
            }
            if (velY < 0){
                velY += 4;
            }
            if (velY>0){
                velY += 0; 
            }
            
            //velX = 0;
        }
        if (code == KeyEvent.VK_LEFT) {
            if (velX == 0){
                velX -= 2;
            }
            if (velX>0){
                velX -= 4;
            }
            if (velX<0){
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
            if (velX == 0){
                velX += 2;
            }
            if (velX<0){
                velX += 4;
            }
            if (velX>0){
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
 
    @Override
    public void keyTyped(KeyEvent e) {
         
    }
}

