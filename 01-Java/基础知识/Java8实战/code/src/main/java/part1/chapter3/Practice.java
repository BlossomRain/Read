package part1.chapter3;

import org.junit.Test;
import part1.chapter1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class Practice {


    @Test
    public void testSort() {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<String> colors = Arrays.asList("green", "red", "green", "red");
        List<Apple> apples = map(weights, colors, Apple::new);
        apples.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println(apples);
    }

    /*****************************
     @Test public void testMethodRefer() {
     List<Integer> weights = Arrays.asList(7, 3, 4, 10);
     List<String> colors = Arrays.asList("green", "red", "green", "red");
     List<Apple> apples = map(weights, colors, Apple::new);
     System.out.println(apples);
     }
     **********************/
    public static List<Apple> map(List<Integer> weights,
                                  List<String> colors,
                                  BiFunction<Integer, String, Apple> f) {
        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < weights.size(); i++) {
            apples.add(f.apply(weights.get(i), colors.get(i)));
        }
        return apples;
    }

    /***************************************************/

    @Test
    public void testFunction() {
        List<Integer> map = map(Arrays.asList("hello", "world", "123"),
                t -> t.length());
        System.out.println(map);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> results = new ArrayList<>();
        for (T t : list) {
            results.add(f.apply(t));
        }
        return results;
    }


    /***************************************************/

    @Test
    public void testConsumer() {
        forEach(Arrays.asList(1, 2, 3, 4), (i) -> System.out.println(i));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    /***************************************************/
    @Test
    public void testPredicate() {
        filter(Arrays.asList(0, 1, 2, 3, 4, 5), i -> i > 0).
                forEach(System.out::print);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t))
                results.add(t);
        }
        return results;
    }
}
