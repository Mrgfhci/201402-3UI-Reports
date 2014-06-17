package Main;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class PanCenter extends JPanel implements ActionListener, KeyListener{
    ImageIcon iiback = new ImageIcon(this.getClass().getResource("backgroundjavagame-01.jpg"));
    Image img = iiback.getImage();
    ImageIcon iihero = new ImageIcon(this.getClass().getResource("char.png"));   
    Image ihero = iihero.getImage();
    int x = 0, y = 0;  //THESE CAN BE CHANGED LATER
    int velX = 0, velY = 0, i = 0, nGrav = 0, nCirWid=10, nCirHi=10;
    boolean bPressed;

//Constructor-------------------------------------------------------------------
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
//Painting----------------------------------------------------------------------
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setSize(size);
        g.drawImage(img, x, y-1277, getWidth(), getHeight(), this);      //MOVING DRAWIMAGE DOWN HERE MAKES SO IMAGE IS DRAWN WITH ABOVE DIMENSIONS
        g.drawImage(ihero, 199, 283, 250, 200, this); 
        Shape Rect = new Rectangle2D.Double(x, y+440, 45000, 10);//Ground
        g2d.fill(Rect);
        Shape Rect2 = new Ellipse2D.Double(290, 390,nCirWid, nCirHi);//Shooting Object
        g2d.setColor(Color.BLACK);
        g2d.fill(Rect2);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
//Repainting & Gravity----------------------------------------------------------
           @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            if (nGrav<5){
                nGrav+=1;
            }
            velY-=nGrav;
            x += velX;              //FIXED RUEBAN'S CODE, TAKEN FROM:http://www.2oi.sgrondin.ca/ss15/motion.html
            y += velY;
            
      //      if (y < -5){           //CURRENTLY HARDCODE, IF WE WANT MULTIPLE LEVELS, WE NEED TO FIX THIS
        //        nGrav = 0;      //STILL FULL OF BUGS... NEED TO FIX
          //      velY = 0;
            //    bPressed = false;//Restriction of infinte jumps
           // }
//Hit Detection-----------------------------------------------------------------
            Shape Rect2 = new Rectangle2D.Double( 199, 283,250,200);
            Shape Rect = new Rectangle2D.Double(x, y+440,45000, 10);
            //int i = 0;
            if (Rect.intersects((Rectangle2D) Rect2)){          //HIT DETECTION IDEAS TAKEN FROM http://stackoverflow.com/questions/335600/collision-detection-between-two-images-in-java
                i+=1;
                y = -5;
                velY = 0;
                nGrav = 0;
                bPressed = false;
            }
           }
//Key Input-------------------------------------------------------------------
        // Thanks Stackoverflow http://stackoverflow.com/questions/9727192/java-moving-a-circle-in-a-gui-with-arrow-keys
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
            }
            if(code == KeyEvent.VK_E){//Shoot right
                nCirWid = 100;
            }
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
            }
        }
           @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
  //          if (code == KeyEvent.VK_SPACE) {
    //            velY = 0;
      //      }
            if (code == KeyEvent.VK_DOWN) {
                velY = 0;
            }
            if (code == KeyEvent.VK_A) {
                velX = 0;
            }
            if (code == KeyEvent.VK_D) {
                velX = 0;
            }
             if (code == KeyEvent.VK_E) {
                nCirWid = 10;
            }

        }
         @Override
        public void keyTyped(KeyEvent e) {

        }
}
