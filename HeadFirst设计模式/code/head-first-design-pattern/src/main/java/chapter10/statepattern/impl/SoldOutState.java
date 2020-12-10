package chapter10.statepattern.impl;

import chapter10.statepattern.GumballMachine;
import chapter10.statepattern.State;

public class SoldOutState implements State {
    transient GumballMachine gumballMachine;
    private static final long serialVersionUID = 2L;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't insert a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs dispensed");
    }
}
