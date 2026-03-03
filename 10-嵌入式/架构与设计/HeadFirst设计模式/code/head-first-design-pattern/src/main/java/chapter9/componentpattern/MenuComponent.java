package chapter9.componentpattern;

import java.util.Iterator;

public abstract class MenuComponent {

    public void add(MenuComponent component){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent component){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }

    public abstract Iterator createIterator();

    public MenuComponent getChild( int i){
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }
}
