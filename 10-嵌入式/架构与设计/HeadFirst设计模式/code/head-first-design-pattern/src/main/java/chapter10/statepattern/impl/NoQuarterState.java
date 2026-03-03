package chapter10.statepattern.impl;

import chapter10.statepattern.GumballMachine;
import chapter10.statepattern.State;

public class NoQuarterState implements State {

    private static final long serialVersionUID = 5L;
    transient GumballMachine gumballmachine;

    public NoQuarterState(GumballMachine gumballmachine) {
        this.gumballmachine = gumballmachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballmachine.setState(gumballmachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is not quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}
