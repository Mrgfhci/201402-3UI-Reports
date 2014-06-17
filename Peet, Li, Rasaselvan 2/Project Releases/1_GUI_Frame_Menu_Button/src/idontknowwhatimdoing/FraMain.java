/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package idontknowwhatimdoing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class FraMain extends JFrame{
    JMenuBar menubar;
    JMenu Options;
    JMenuItem miExit;
    JMenuItem miCredits;
    JMenuItem miHelpme;
    
    FraMain(){
        setLayout(new FlowLayout());
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        Options = new JMenu ("Options");
        menubar.add(Options);
        miExit = new JMenuItem("Exit");
        Options.add(miExit);
        Exit exits = new Exit();
        miExit.addActionListener(exits);
        miCredits = new JMenuItem("Credits");
        alCredits credits = new alCredits();
        miCredits.addActionListener(credits);
        Options.add(miCredits);
        miHelpme = new JMenuItem("Help");
        Options.add(miHelpme);
        alHelp helpplayer = new alHelp();
        miHelpme.addActionListener(helpplayer);
        
        PanMain panmain = new PanMain();
        add(panmain);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Le thing");
        setVisible(true);
    }
    public class Exit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent exit){
            System.exit(0);
        }
    }
    public class alCredits implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Bonjour");
        }
    }
    public class alHelp implements ActionListener{
        public void actionPerformed (ActionEvent b){
            System.out.println("You figure it out");
        }
    }
}
