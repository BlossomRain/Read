package eventTracer;

import java.awt.*;

import javax.swing.*;

/**
 * @version 1.14 2015-08-20
 * @author Cay Horstmann
 */
public class EventTracerTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
            {
               JFrame frame = new EventTracerFrame();
               frame.setTitle("EventTracerTest");      
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            });
   }
}

class EventTracerFrame extends JFrame
{
   public EventTracerFrame()
   {
      // add a slider and a button
      add(new JSlider(), BorderLayout.NORTH);
      add(new JButton("Test"), BorderLayout.SOUTH);

      // trap all events of components inside the frame
      EventTracer tracer = new EventTracer();
      tracer.add(this);
      pack();
   }
}
