import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.security.Key;

public class GamePanel extends JPanel {
    KeyBoardHandler h;
    MouseHandler m;
    Player p = new Player();
    Bullet b = new Bullet(0,0, 0,0);

    double delta = 0.02;

    public GamePanel(KeyBoardHandler h, MouseHandler m) {
        super();
        setDoubleBuffered(true);
        this.h = h;
        this.m = m;
        add(new JButton("BALLS"));
    }

    public void update(){
        if(h.w) {
            p.move(0, delta * -1);
            //repaint();
        }
        else if(h.s) {
            p.move(0, delta);
            //repaint();
        }
        if(h.a) {
            p.move(delta * -1,0);
            //repaint();
        }
        else if(h.d) {
            p.move(delta,0);
            //repaint();
        }

        if(m.left) {
            b = new Bullet(p.x, p.y, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
        }

        b.move(b.dx * delta, b.dy * delta);
        b.rotate(0,0);

        p.rotate(MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //repaint();
        g.drawImage(p.i,(int)p.x,(int)p.y,null);
        g.drawImage(b.i,(int)b.x,(int)b.y,null);
    }
}
