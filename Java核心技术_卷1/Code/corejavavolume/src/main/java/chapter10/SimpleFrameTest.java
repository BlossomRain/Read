package chapter10;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new SimpleFrame();
            frame.setTitle("Hello Swing");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
