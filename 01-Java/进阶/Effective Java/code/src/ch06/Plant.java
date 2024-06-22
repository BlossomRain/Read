package ch06;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}

class PlantTest {
    // 假定花园数据如下
    Plant[] garden = new Plant[]{
            new Plant("A", Plant.LifeCycle.ANNUAL),
            new Plant("B", Plant.LifeCycle.BIENNIAL),
            new Plant("C", Plant.LifeCycle.PERENNIAL),
            new Plant("D", Plant.LifeCycle.BIENNIAL),
            new Plant("E", Plant.LifeCycle.PERENNIAL),
    };

    // Using a stream and an EnumMap to associate data with an enum
    void test4() {
        System.out.println(
                Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet()))
        );
    }

    // Naive stream-based approach - unlikely to produce an EnumMap!
    void test3() {
        System.out.println(Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle)));
    }

    // Using an EnumMap to associate data with an enum
    void test2() {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycle);
    }

    // Using ordinal() to index into an array - DON'T DO THIS!
    void test1() {
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

// Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }
}