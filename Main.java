import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame {
    KeyBoardHandler h = new KeyBoardHandler();
    MouseHandler mh = new MouseHandler();
    GamePanel g;
    int delay = 12;
    double delta = 1000 / delay;
    int width, height;
    int increment = 0;

    public Main() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double dwidth = screenSize.getWidth();
        double dheight = screenSize.getHeight();
        setSize((int)dwidth,(int)dheight);
        width = getWidth();
        height = getHeight();
        g = new GamePanel(h, mh, width, height);
        add(g);
        g.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        
        setVisible(true);
        addKeyListener(h);
        addMouseListener(mh);
        setFocusable(true);
        requestFocus();
        Timer t = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    if(g.playing){
                        repaint();
                    }
                    Thread.sleep(delay);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                g.update();
                g.paintComponent(getGraphics());
            }
        }
        );
        t.start();
    }


    public static void main(String[] args){
        new Main();
    }
}