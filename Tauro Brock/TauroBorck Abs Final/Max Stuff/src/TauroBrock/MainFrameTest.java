package TauroBrock;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrameTest extends JFrame {
    //Name of Frame, Dementions of the frame and other verables about the frame

    public MainFrameTest() {
        //JFrame frame = new JFrame();
        add(new PanTest1b());
        //add(new PanTest2());
        
        
        setSize(750, 900);
        setTitle("Empty Frame");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
