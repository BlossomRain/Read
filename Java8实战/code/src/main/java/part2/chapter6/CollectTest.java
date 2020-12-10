package part2.chapter6;

import org.junit.Test;
import part2.chapter4.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectTest {
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    @Test
    public void testGroup2(){
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            return CaloricLevel.FAT;
                        })));
        System.out.println(collect);
    }

    @Test
    public void testGroup(){
        Map<Dish.Type, List<Dish>> collect = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(collect);
    }

    @Test
    public void testMax() {
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish.get().getName());
        Integer collect = menu.stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println(collect);

        String menus = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));
        System.out.println(menus);
    }
}
