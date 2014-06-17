package hitbox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hitbox{
    public static void main(String[] args) {
        FraMain framain = new FraMain();
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
        System.out.println("X: " + x);
        System.out.println("Y: " + y);

    }
    
}
