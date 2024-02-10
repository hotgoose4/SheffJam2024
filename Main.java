import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame {
    KeyBoardHandler h = new KeyBoardHandler();
    MouseHandler mh = new MouseHandler();
    GamePanel g = new GamePanel(h, mh);
    int delay = 20;
    double delta = 1000 / delay;

    public Main() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        setSize(1920, 1080);
        add(g);
        addKeyListener(h);
        addMouseListener(mh);
        setFocusable(true);
        requestFocus();
        Timer t = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    repaint();
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