/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

public class PanHero extends JPanel{
    ImageIcon iihero = new ImageIcon(this.getClass().getResource("eating-grass.png"));
    Image ihero = iihero.getImage();
    
    public PanHero(){
        super();
        this.setOpaque(false);
        this.setLayout( null ) ;
        setPreferredSize( new Dimension( 300, 304 ) );      //IMAGE IS SCALED TO FIT
        setMaximumSize(new Dimension (300,304));
        
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = new Dimension(ihero.getWidth(null), ihero.getHeight(null));
        setSize(size);
        g.drawImage(ihero, 0, 0, getWidth(), getHeight(), this);      //MOVING DRAWIMAGE DOWN HERE MAKES SO IMAGE IS DRAWN WITH ABOVE DIMENSIONS
        Graphics2D g2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
}
