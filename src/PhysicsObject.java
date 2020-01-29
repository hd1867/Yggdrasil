import java.awt.*;


public abstract class PhysicsObject {

    protected String ID;
    protected boolean pinned;
    protected boolean massive;
    protected double mass;
    protected double speedX;
    protected double speedY;
    protected double accX;
    protected double accY;
    protected Point location;

    public PhysicsObject(String ID, boolean pinned, boolean massive, double mass, int x, int y) {
        this.ID = ID;
        this.pinned = pinned;
        this.massive = massive;
        this.mass = mass;
        location = new Point(x, y);
        speedX = 0;
        speedY = 0;
        accX = 0;
        accY = Physics.g;
        Physics.objects.add(this);
    }

    public void tick(Window w, double delta){
        if(massive)
            if(location.y < w.canvas.getSize().height) {
                //Change in position
                speedY += accY * delta;
                location.y += speedY;
            }

            else{
                location.y = w.canvas.getSize().height;
                speedY = 0;
                accY = 0;
            }

            speedX += accX * delta;
            location.x += speedX;
            //Global Collision

    }

    public Point getLocation() {
        return location;
    }

    public abstract void render(Graphics g);
}
