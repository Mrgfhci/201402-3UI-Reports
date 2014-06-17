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

public class PanCenter extends JPanel{
    ImageIcon iiback = new ImageIcon(this.getClass().getResource("that thing that minecraft made and i copied.jpg"));
    Image img = iiback.getImage();
    ImageIcon iihero = new ImageIcon(this.getClass().getResource("eating-grass.png"));
    Image ihero = iihero.getImage();
    private int nX = 0, nY = 0;  //THESE CAN BE CHANGED LATER
    
    public PanCenter(){
        // got this here: http://stackoverflow.com/questions/5921175/how-to-set-jpanels-width-and-height
        setPreferredSize( new Dimension( 500, 504 ) );      //IMAGE IS SCALED TO FIT
        setMaximumSize(new Dimension (500,504));
        
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
        g.drawImage(img, nX, nY, getWidth(), getHeight(), this);      //MOVING DRAWIMAGE DOWN HERE MAKES SO IMAGE IS DRAWN WITH ABOVE DIMENSIONS
        //Dimension size2 = new Dimension(ihero.getWidth(null), ihero.getHeight(null));
        //setSize(size2);
        g.drawImage(ihero, 199, 100, 200, 200, this);
        Graphics2D g2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
}