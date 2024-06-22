package chapter9.interatorpattern;

import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args){
        Menu dinerMenu = new DinerMenu();
        Iterator iterator = dinerMenu.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
