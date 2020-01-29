import java.awt.*;

public class PhysCircle extends PhysicsObject {

    private int radius;
    private Color color;

    public PhysCircle(String ID, boolean pinned, boolean massive, double mass, int x, int y, int radius, Color color) {
        super(ID, pinned, massive, mass, x, y);
        this.radius = radius;
        this.color = color;
    }


    @Override
    public void tick(Window w, double delta){
        if(massive)
            if(location.y < w.canvas.getSize().height - radius) {
                //Change in position
                speedY += accY * delta;
                location.y += speedY;
            }

            else{
                location.y = w.canvas.getSize().height - radius;
                speedY = 0;
                accY = 0;
            }

        speedX += accX * delta;
        location.x += speedX;
        //Global Collision

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawOval(getLocation().x, getLocation().y, radius, radius);
        g.fillOval(getLocation().x, getLocation().y, radius, radius);
    }
}
