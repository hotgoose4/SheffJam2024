public class Bullet extends Entity{
    double dx, dy;
    public Bullet(double x, double y, double mx, double my){
        super("assets\\sprites\\weapons\\","pistol_1.png");
        velocity = 1;
        this.x = x;
        this.y = y;
        dx = mx - x;
        dy = -(y - my);
    }
}
