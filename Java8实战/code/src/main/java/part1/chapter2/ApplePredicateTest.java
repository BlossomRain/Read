package part1.chapter2;

import part1.chapter1.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 没有使用Java8的实现方式
 */
public abstract class ApplePredicateTest implements ApplePredicate {

    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple))
                result.add(apple);
        }

        return result;
    }
}
