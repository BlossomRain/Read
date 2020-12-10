package imageIO;

import java.awt.*;
import javax.swing.*;

/**
 * This program lets you read and write image files in the formats that the JDK supports. Multi-file
 * images are supported.
 * @version 1.03 2012-01-26
 * @author Cay Horstmann
 */
public class ImageIOTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new ImageIOFrame();
               frame.setTitle("CompositeTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}