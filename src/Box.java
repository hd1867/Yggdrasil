import java.awt.*;

public class Box extends PhysicsObject {

    private Rectangle rectangle;
    private Color color;

    public Box(String ID, boolean pinned, boolean massive, double mass, int x, int y, int width, int height, Color color) {
        super(ID, pinned, massive, mass, x, y);
        rectangle = new Rectangle(x, y, width, height);
        this.color = color;
    }

    public Box(String ID, boolean pinned, boolean massive, double mass, Rectangle rectangle, Color color) {
        super(ID, pinned, massive, mass, rectangle.x, rectangle.y);
        this.rectangle = rectangle;
        this.color = color;
    }

    @Override
    public void tick(Window w, double delta){
        if(massive)
            if(location.y < w.canvas.getSize().height - rectangle.height) {
                //Change in position
                speedY += accY * delta;
                location.y += speedY;
            }

            else{
                location.y = w.canvas.getSize().height - rectangle.height;
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
        g.drawRect(getLocation().x, getLocation().y, rectangle.width, rectangle.height);
        g.fillRect(getLocation().x, getLocation().y, rectangle.width, rectangle.height);
    }
}
