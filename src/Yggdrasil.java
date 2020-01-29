import java.awt.*;

public class Yggdrasil {

    private static Window window;

    private static void tick(Window w, double delta){
        for(PhysicsObject o : Physics.objects){
            o.tick(w, delta);
        }
    }

    private static void render(Graphics g){
        g.clearRect(0, 0, window.canvas.getWidth(), window.canvas.getHeight());
        for(PhysicsObject o : Physics.objects){
            o.render(g);
        }
    }

    public static void main(String[] args){
        //Create a window
        window = new Window("Yggdrasil", 800, 600);
        Box box = new Box("Box1", false, true, 1, 300, 300, 50, 20, Color.red);
        PhysCircle circle = new PhysCircle("Circle1", false, true, 1, 500, 300, 20, Color.BLUE);
        Graphics g = window.getGraphics();

        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        int fps = 0;
        int lastFpsTime = 0;

        // keep looping round til the game ends
        while (true)
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: "+fps+")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            tick(window, delta);

            // draw everyting
            render(g);

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try{
                Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
