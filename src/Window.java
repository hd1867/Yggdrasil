import javax.swing.*;
import java.awt.*;

public class Window {

    Canvas canvas;

    public Window(String title, int length, int height) {

        //1. Create the frame.
        JFrame frame = new JFrame(title);

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3.Add a canvas
        canvas = new Canvas();
        canvas.setSize(length, height);
        canvas.setBackground(Color.WHITE);

        frame.add(canvas);

        //3. Size the frame.
        frame.pack();

        //4. Show it.
        frame.setVisible(true);
    }

    public Graphics getGraphics(){
        return canvas.getGraphics();
    }
}
