package part1.chapter2;

import org.junit.Test;
import part1.chapter1.Apple;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Examples {
    List<Apple> inventory = new ArrayList<>();

    @Test
    public void testSort() {
        inventory.sort((a1, a2) -> {
            return Double.compare(a1.getWeight(), a2.getWeight());
        });
    }

    @Test
    public void testRunnable() {
        new Thread(() -> System.out.println("hello world"));
    }

    @Test
    public void testGUI(){
        JButton button = new JButton();
        new Button().addActionListener(e ->{});
    }
}
