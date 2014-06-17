/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idontknowwhatimdoing;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanHUD extends JPanel{
    private JLabel lbinsult;
    private JButton jbinsultme;
    private int nHealth = 100;
    PanHUD(){
        setLayout(new GridLayout(2, 1));
        setSize(500,200);
        setVisible(true);
        setOpaque(true);
        revalidate();
        repaint();
        jbinsultme = new JButton("Insult me!");
        add (jbinsultme);
        alInsult insult = new alInsult();
        jbinsultme.addActionListener(insult);
        lbinsult = new JLabel ("100");
        add(lbinsult);
    }
    public class alInsult implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent insult){
            String sHealth;
            nHealth -= 10;
            sHealth = Integer.toString(nHealth);
            lbinsult.setText(sHealth);
            if (nHealth <= 0){
                lbinsult.setText("you died");
            }
           // lbinsult.revalidate();
           // lbinsult.repaint();
        }
    }
}
