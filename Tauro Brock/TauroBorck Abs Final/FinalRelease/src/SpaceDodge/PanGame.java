package SpaceDodge;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanGame extends JPanel implements ActionListener, KeyListener {

    private BufferedImage imgShip, imgBack, imgRock, imgOver, imgStart;
    int nRockX = 570, nRockY = 0, nNewX = 1, nShipX = 320, ShipY = 700, nvelX = 0, nScore = 0, nChangeX, nHighestnScore = 0;
    boolean bGameOver = false, bGameStart = false, bShipMoving = false;

    public PanGame() {
        // got this here: http://stackoverflow.com/questions/5921175/how-to-set-jpanels-width-and-height
        Timer t = new Timer(1, this);
        t.start();
        setFocusable(true);
        addKeyListener(this);
        try {
            imgStart = ImageIO.read(new File("Start.jpg"));
            imgOver = ImageIO.read(new File("GameOver.png"));
            imgRock = ImageIO.read(new File("YOLOROCKZ.png"));
            imgShip = ImageIO.read(new File("F5S4.png"));
            imgBack = ImageIO.read(new File("bg1.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bGameStart == true) {
            if (bGameOver == false) {
                g.drawImage(imgBack, 0, 0, 900, 900, null);
                g.drawImage(imgShip, nShipX, ShipY, 100, 150, null);
                g.drawImage(imgRock, nRockX, nRockY, 150, 150, null);
                g.setColor(Color.white);
                g.drawString("Your nScore " + nScore, 60, 60);
                g.setColor(Color.white);
                g.drawString("High nScore " + nHighestnScore, 60, 40);
            }
            if (bGameOver) {
                g.drawImage(imgOver, 0, 0, 750, 900, null);
                g.setColor(Color.white);
                g.drawString("Your nScore " + nScore, 60, 60);
                g.setColor(Color.white);
                g.drawString("High nScore " + nHighestnScore, 60, 40);
            }
        } else if (bGameStart == false) {
            g.drawImage(imgStart, 0, 0, 750, 900, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (bGameStart == true) {
            if (bGameOver == false) {
                nScore++;
                repaint();
                if (Math.abs(nChangeX - nShipX) != 250) {
                    nShipX += nvelX;
                } else {
                    bShipMoving = false;
                }
                nRockY += 4;
                if (nRockY == 900) {
                    nNewX = (int) (Math.random() * 3);
                    nRockY = -200;
                    if (nNewX == 0) { //left
                        nRockX = 70;
                    } else if (nNewX == 1) { //center
                        nRockX = 320;
                    } else { //right
                        nRockX = 570;
                    }
                }
                if (nRockY > 650 && nRockY < 750 && nRockX == nShipX) {
                    if (nHighestnScore < nScore) {
                        nHighestnScore = nScore;
                    }
                    bGameOver = true;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            bGameStart = true;
        }
        if (code == KeyEvent.VK_ENTER) {
            if (bGameOver) {
                nScore = 0;
                nRockX = 570;
                nRockY = 0;
                nShipX = 320;
                nvelX = 0;
                bShipMoving = false;
                bGameOver = false;
            }
        }
        if (code == KeyEvent.VK_LEFT && nShipX > 70) {
            if (!bShipMoving) {
                nChangeX = nShipX;
                nvelX = -5;
            }
            bShipMoving = true;

        }
        if (code == KeyEvent.VK_RIGHT && nShipX < 570) {
            if (!bShipMoving) {
                nChangeX = nShipX;
                nvelX = 5;
            }
            bShipMoving = true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
