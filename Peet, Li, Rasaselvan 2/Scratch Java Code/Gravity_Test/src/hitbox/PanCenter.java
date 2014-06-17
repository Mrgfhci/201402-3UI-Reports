package hitbox;

import java.awt.*;
import javax.swing.*;
public class PanCenter extends JPanel {
    
    @Override
    public void paint(Graphics g){
          g.drawOval(50, 40, 60, 60); //FOR CIRCLE
          g.drawRect(20,40, 90, 100);//rectangle
     }

}
