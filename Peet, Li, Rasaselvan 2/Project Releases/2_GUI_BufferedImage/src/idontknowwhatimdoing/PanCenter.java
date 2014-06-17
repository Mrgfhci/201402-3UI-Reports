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
    
    public PanCenter(){
        // got this here: http://stackoverflow.com/questions/5921175/how-to-set-jpanels-width-and-height
        setPreferredSize( new Dimension( 300, 304 ) );      //IMAGE IS SCALED TO FIT
        //setResizable( false );
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        Graphics2D g2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
}