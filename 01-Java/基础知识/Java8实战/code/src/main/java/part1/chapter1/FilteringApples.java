package part1.chapter1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        return inventory.stream().filter(p).collect(Collectors.toList());
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
