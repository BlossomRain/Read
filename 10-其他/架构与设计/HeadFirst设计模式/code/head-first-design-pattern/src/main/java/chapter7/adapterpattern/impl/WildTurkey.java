package chapter7.adapterpattern.impl;

import chapter7.adapterpattern.Turkey;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble...");
    }

    @Override
    public void fly() {
        System.out.println("Turkey flying...");
    }
}
