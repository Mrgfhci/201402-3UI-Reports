/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ball_moving;

import javax.swing.*;
import java.awt.*;

public class PanMain extends JPanel{
    PanCenter2 pancenter2 = new PanCenter2();
    
    public PanMain(){
        setLayout(new BorderLayout());
        add(pancenter2, BorderLayout.CENTER);
        
    }
}
