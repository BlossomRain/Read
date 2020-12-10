package part1.chapter1;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class BasicTest {

    @Test
    public void testAppleFilter(){
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> apples = FilteringApples.filterApples(inventory, FilteringApples::isGreenApple);
        apples.stream().forEach(System.out::println);
    }

    @Test
    public void testLambda(){
        File[] files = new File(".").listFiles(File::isHidden);
        Arrays.stream(files).forEach(System.out::println);
    }
}
