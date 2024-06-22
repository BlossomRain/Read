package chapter11.proxy;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

public class ImageProxyTest {
    ImageComponent imageComponent;
    JFrame jFrame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable<String,String> cds = new Hashtable<>();

    public static void main(String[] args) throws Exception {
        new ImageProxyTest();
    }

    public ImageProxyTest() throws Exception {
        cds.put("LaDigue", "https://cn.bing.com/th?id=OHR.AsilomarSB_ZH-CN1074865975_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp");

        URL initURL = new URL(cds.get("LaDigue"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        jFrame.setJMenuBar(menuBar);

        Enumeration<String> keys = cds.keys();
        while (keys.hasMoreElements()){
            String name = keys.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener((event)->{
                imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
                jFrame.repaint();
            });
        }
        // 建立框架
        Icon icon = new ImageProxy(initURL);
        imageComponent = new ImageComponent(icon);
        jFrame.getContentPane().add(imageComponent);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800,600);
        jFrame.setVisible(true);

    }

    private URL getCDUrl(String name) {
        try {
            return new URL(cds.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
