package chapter9.interatorpattern;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu{
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("a","PancakeHouseMenu",true,1.1);
        addItem("b","PancakeHouseMenu",true,1.1);
        addItem("c","PancakeHouseMenu",true,1.1);
        addItem("d","PancakeHouseMenu",true,1.1);
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menuItems.add(item);
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }

    public Iterator getIterator(){
        return menuItems.iterator();
    }
}
