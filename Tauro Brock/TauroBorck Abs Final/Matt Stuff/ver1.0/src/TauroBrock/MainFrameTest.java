package TauroBrock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainFrameTest extends JFrame {
    //Name of Frame, Dementions of the frame and other verables about the frame

    public MainFrameTest() {
        //JFrame frame = new JFrame();
        add(new PanTest1());
        
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
