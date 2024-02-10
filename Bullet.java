public class Bullet extends Entity{
    double dx, dy;
    double distanceFromOrigin;
    public Bullet(double x, double y, double mx, double my){
        super("assets\\sprites\\bullets\\","bullet_1.png");
        velocity = 200;
        this.x = x;
        this.y = y;
        dx = mx - x;
        dy = -(y - my);
        double magnitude = Math.sqrt(dx*dx + dy*dy);
        dx /= magnitude;
        dy /= magnitude;
        setDistanceFromOrigin();
    }

    public void setDistanceFromOrigin() {
        distanceFromOrigin = Math.sqrt(x*x + y*y);
    }
}
