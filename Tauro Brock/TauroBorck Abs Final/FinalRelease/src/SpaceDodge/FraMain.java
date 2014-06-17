package SpaceDodge;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FraMain extends JFrame {

    public FraMain() {

        add(new PanGame());
        setSize(750, 900);
        setTitle("Space Dodge");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {  //closing the window
                System.exit(0);
            }
        });

    }
}
