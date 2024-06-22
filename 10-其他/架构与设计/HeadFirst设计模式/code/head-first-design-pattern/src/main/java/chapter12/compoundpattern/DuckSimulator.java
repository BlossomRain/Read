package chapter12.compoundpattern;

import chapter12.compoundpattern.duck.AbstrackDuckFactory;
import chapter12.compoundpattern.duck.Flock;
import chapter12.compoundpattern.duck.QuackCounter;
import chapter12.compoundpattern.duck.Quackable;
import chapter12.compoundpattern.duck.impl.*;
import chapter12.compoundpattern.goose.Goose;
import chapter12.compoundpattern.goose.GooseAdapter;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator sim = new DuckSimulator();
        AbstrackDuckFactory factory = new CountingDuckFactory();
        sim.simulate(factory);
    }

    private void simulate(AbstrackDuckFactory factory) {

        Quackable duckCall = factory.createDuckCall();
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redHeadDuck = factory.createRedHeadDuck();
        Quackable rubberDuck = factory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());

        System.out.println("\n---------Duck Simulator : With Composite-----------\n");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(duckCall);
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(goose);


        Flock flockOfMallards = new Flock();
        for (int i = 0; i < 4; i++) {
            flockOfMallards.add(factory.createMallardDuck());
        }
        flockOfDucks.add(flockOfMallards);

        System.out.println("\n---------Duck Simulator : Whole Flock-----------\n");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);
        simulate(flockOfDucks);

//        System.out.println("\n---------Duck Simulator : Mallard Duck Flock-----------\n");
//        simulate(flockOfMallards);
//
//        System.out.println("\n---------Duck Counter-----------\n");
//        System.out.println("The ducks quacked " + QuackCounter.getCount() + " times");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
