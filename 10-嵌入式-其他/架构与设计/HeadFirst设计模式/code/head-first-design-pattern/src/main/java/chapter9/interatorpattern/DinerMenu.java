package chapter9.interatorpattern;

import java.util.Iterator;

public class DinerMenu implements Menu{
    static  final  int MAX_VALUE = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu( ) {
        this.menuItems = new MenuItem[MAX_VALUE];

        addItem("1","DinerMenu",true,11.1);
        addItem("2","DinerMenu",true,11.1);
        addItem("3","DinerMenu",true,11.1);
        addItem("4","DinerMenu",true,11.1);
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems < MAX_VALUE){
            menuItems[numberOfItems++] = item;
        }else{
            System.err.println("Sorry! Menu is full...");
        }
    }

    public Iterator getIterator(){
        return new DinerMenuIterator();
    }

    class DinerMenuIterator implements Iterator{

        private int position = 0;
        @Override
        public boolean hasNext() {
            return position < numberOfItems;
        }

        @Override
        public Object next() {
            return menuItems[position++];
        }
    }
}
