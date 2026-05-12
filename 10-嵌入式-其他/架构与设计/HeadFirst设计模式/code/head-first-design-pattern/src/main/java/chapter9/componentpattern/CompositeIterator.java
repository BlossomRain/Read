package chapter9.componentpattern;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {

    Stack<Iterator<MenuComponent>> stack  = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty())return false;
        else{
            Iterator<MenuComponent> iterator = stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }else{
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()){
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent component = iterator.next();
            if (component instanceof Menu){
                stack.push(component.createIterator());
            }
            return component;

        }else {
            return null;
        }
    }
}
