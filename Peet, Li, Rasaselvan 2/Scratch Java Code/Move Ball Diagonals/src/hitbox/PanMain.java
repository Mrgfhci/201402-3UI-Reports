/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitbox;

import java.awt.*;
import javax.swing.*;

public class PanMain extends JPanel{
    PanCenter2 center = new PanCenter2();
    public PanMain(){
        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
    }
}
