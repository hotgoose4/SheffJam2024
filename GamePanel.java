
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;

public class GamePanel extends JPanel {
    int width, height;
    KeyBoardHandler h;
    MouseHandler m;
    Player p = new Player();
    BulletHandler b;
    SpiderHandler s;
    boolean playing = true;

    double delta = 0.02;

    public GamePanel(KeyBoardHandler h, MouseHandler m, int width, int height) {
        super();
        setDoubleBuffered(true);
        this.h = h;
        this.m = m;
        this.width = width;
        this.height = height;
        b = new BulletHandler(width, height, p);
        s = new SpiderHandler(width, height, p);
        s.addSpider();
    }

    public void update(){
        if(h.space){
            playing = false;
        } else {
            playing = true;
        }
        if(playing){
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

            if(p.shooting) {
                p.switchImage();
            }

            if(m.left) {
                b.addBullet(new Bullet(p.x, p.y, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY()));
                p.switchImage();
            }
            //for(int i = 0; i < 2; i++ ){
            if(Math.random() < 0.01){
                s.addSpider();
            }
            //}
            s.updateSpiders();
            b.updateBullets();
            for(int i = 0; i < s.spiderCounter; i++){
                double comp1 = s.spiders[i].distanceFromOrigin;
                for(int j = 0; j < b.bulletCounter; j++) {
                    double comp2 = b.bullets[j].distanceFromOrigin;
                    if((comp1 - 5 < comp2 )&& (comp1 + 5 > comp2)) {
                        double sx = s.spiders[i].x; double sy = s.spiders[i].y;
                        double bx = b.bullets[j].x; double by = b.bullets[j].y;
                        int tolerance = 3;
                        if((sx - tolerance < bx )&& (sx + tolerance > bx) && (sy - tolerance < by )&& (sy + tolerance > by)) {
                            s.spiders[i].health -= p.damage;
                        }
                    }
                }
            }
            p.rotate(MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
        }
    }

    public void paintHealthBar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, (int)(width*((double)p.health/100)), 30);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Health: " + (int)p.health + "/" + (int)p.maxHealth , 10, 20);
    }

    public void paintXpBar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, height -30, (int)(width*((double)p.xp/p.nextLevel)), 30);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("XP: " + (int)p.xp + "/" + (int)p.nextLevel , 10, height-10);
    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //repaint();
        if(playing || true){
            b.drawBullets(g);
            g.drawImage(p.i,(int)p.x,(int)p.y,null);
            s.drawSpiders(g);
            paintHealthBar(g);
            paintXpBar(g);
        }
    }
}
