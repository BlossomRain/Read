package chapter11.proxy;

import javax.swing.*;
import java.awt.*;

public class ImageComponent extends JComponent{

    private Icon icon;
    public ImageComponent(Icon icon) {
        this.icon =icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = icon.getIconHeight();
        int width = icon.getIconWidth();
        int x = (800-width)/2;
        int y = (600-height)/2;
        icon.paintIcon(this,g,x,y);
    }
}
