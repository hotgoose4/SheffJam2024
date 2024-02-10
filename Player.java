import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity{
    BufferedImage secondImage;
    boolean shooting = false;
    int width, height;
    double health = 100;
    double maxHealth = 100;
    double xp = 200;
    double nextLevel = 1000;
    double damage = 200;

    public Player() {
        super("assets\\sprites\\player\\", "player_4.png");
        try{
            File p = new File("assets\\sprites\\player\\");
            secondImage = ImageIO.read(new File(p, "player_5.png"));
            width = secondImage.getWidth();
            height = secondImage.getHeight();
        } catch(IOException e){
            e.printStackTrace();
        }
        x = 960;
        y = 540;
        velocity = 50;
    }

    public void switchImage() {
        BufferedImage temp = defaultImage;
        defaultImage = secondImage;
        secondImage = temp;
        shooting = !shooting;
    }

}
