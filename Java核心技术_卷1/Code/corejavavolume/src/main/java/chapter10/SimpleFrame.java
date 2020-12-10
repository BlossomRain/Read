package chapter10;

import javax.swing.*;
import java.awt.*;

public class SimpleFrame extends JFrame {

    public  SimpleFrame(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // set frame width, height and let platform pick screen location
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);
        // set frame icon
        Image img = new ImageIcon("icon.png").getImage() ;
        setIconImage(img);
    }


}
