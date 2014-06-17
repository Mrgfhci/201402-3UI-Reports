
package ball_moving;

import java.awt.*;
import javax.swing.*;

public class FraMain extends JFrame{
    FraMain(){
        PanMain PanMain = new PanMain();
        setSize(500, 500);
        setTitle("Hitbox Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(PanMain);
        setVisible(true);
    }
}
