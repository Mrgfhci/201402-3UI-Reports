/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hitbox;

import javax.swing.*;
import java.awt.*;

public class PanMain extends JPanel{
    PanCenter pancenter = new PanCenter();
    PanCenter2 pancenter2 = new PanCenter2();
    
    public PanMain(){
        setLayout(new BorderLayout());
        add(pancenter,BorderLayout.CENTER);
        add(pancenter2, BorderLayout.CENTER);
        
    }
}
