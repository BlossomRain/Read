package chapter10.statepattern.impl;

import chapter10.statepattern.GumballMachine;
import chapter10.statepattern.State;

public class SoldState implements State {

    transient GumballMachine gumballMachine;
    private static final long serialVersionUID = 6L;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait,we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you have turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops,out of gumballs");
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
