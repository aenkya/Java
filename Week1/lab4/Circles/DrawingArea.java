 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingArea extends JPanel {
 
     // You only need to edit the method below.
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      // the size of the circle
      int size = 350;
      // the color (this is blue, believe it or not, play around with different values)
      int icol = 255;
      Color c = new Color(icol);
      g.setColor(c);
      
      // You might want to introduce a loop somewhere here.

      // 10 cocentric circles
      for(int i=0; i<10;i++) {
        g.drawOval(200-((size-(i*20))/2), 200-((size-(i*20))/2), size-(i*20), size-(i*20));
      }
      
    }// the end of the method....
}