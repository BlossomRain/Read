package part1.chapter2.impl;

import part1.chapter1.Apple;
import part1.chapter2.ApplePredicate;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
