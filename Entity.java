import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity {
    double x, y;
    double direction;
    double velocity;
    BufferedImage defaultImage;
    BufferedImage i;

    public Entity(String path, String file) {
        try{
            File p = new File(path);
            defaultImage = ImageIO.read(new File(p, file));
            i = defaultImage;
        } catch(IOException e){
            e.printStackTrace();
        }
        x = 0;
        y = 0;
        velocity = 0;
    }

    public void move(double x, double y) {
        this.x += x * velocity;
        this.y += y * velocity;
    }

    public void rotate(double x, double y) {
        double dx = x - this.x;
        double dy = this.y - y;
        double addition = 0;
        if(dx<0){
            addition = Math.PI;
        }
        direction = Math.atan(-dy/dx) + addition;
        BufferedImage newImage = new BufferedImage(defaultImage.getHeight(), defaultImage.getHeight(), defaultImage.getType() );
        Graphics2D g2d = newImage.createGraphics();
        g2d.rotate(direction, newImage.getWidth() / 2,
                  newImage.getHeight() / 2);
        g2d.drawImage(defaultImage, null, 0, 0);
        i = newImage;
    }
}

