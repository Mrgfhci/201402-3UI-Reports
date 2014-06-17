package hitbox;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class PanCenter2 extends JPanel implements ActionListener, KeyListener{     
    double x=50, y= 200, x2 = 350, y2 = 204;
    double nSize = 10, nSize2 = 10, nCount= 0;
    double velX = 0, velY = 0, nX = 0, nY = 0;
    
    
    public PanCenter2() {
        Timer t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
        
    }
    // Circle Black
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape circle = new Ellipse2D.Double(x, y, 40, 40);
        g2.setColor(Color.BLACK);
        g2.fill(circle);
        System.out.println(x +" " +y);
    }
    //Other Graphics---------------------------------------------------------------
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape circle2 = new Rectangle2D.Double(x2,y2, nSize ,nSize2);//circle blue 
        g2.setColor(Color.BLUE);
        g2.fill(circle2);
        
        
        Shape Rect = new Rectangle2D.Double(-10, 240, 600, 900);//Ground
        g2.setColor(Color.GREEN);
        g2.fill(Rect);
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        x += velX;
        y += velY;
        x2 -= 2;
        if(nCount == 10){
            nSize = 10;
            nSize2 = 10;
            nCount = 0;
        }
        
        if(x2<=(-20)){// reset blue ball
            x2 = 600;
            
        }
        if(y>= 200){// Ground
            y = 200;
        }
        
        if(x<=(x2+nSize)&&y<=(y2+nSize2)&&x2<=(x+20)&&y2<=(y+20)){
            System.out.println("HIT!");
            x2 = 600;
            nCount += 1;
            nSize += 10;
            nSize2 += 10;
            //y2 = (int)(Math.random()*500) + 1;
            System.out.println("x: "+nCount);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            velY = -2;
        //    velX = 0;
        }
 //       if (code == KeyEvent.VK_DOWN) {
   //         velY = 2;
     //       velX = 0;
      //  }
        if (code == KeyEvent.VK_A) {
            if (x < 0) {
                velY = 0;
                velX = 0;
            }
            else {
            //velY = 0;
            velX = -2;
            }
        }
        if (code == KeyEvent.VK_D) {
            if (x >= 444) {
                velY = 0;
                velX = 0;
            }
            else{
          //  velY = 0;
            velX = 2;
            }
        }
    }
    
   public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            velY = +2;
          //  velX = 0;
        }
       // if (code == KeyEvent.VK_DOWN) {
    //        velY = 0;
     //       velX = 0;
     //   }
        if (code == KeyEvent.VK_A) {
       //     velY = 0;
            velX = 0;
        }
        if (code == KeyEvent.VK_D) {
        //    velY = 0;
            velX = 0;
        }
     
    }
   
    @Override
    public void keyTyped(KeyEvent e) {
         
    }
}

