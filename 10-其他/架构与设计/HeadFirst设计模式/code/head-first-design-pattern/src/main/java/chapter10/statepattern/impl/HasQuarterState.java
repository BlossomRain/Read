package chapter10.statepattern.impl;

import chapter10.statepattern.GumballMachine;
import chapter10.statepattern.State;

import java.util.Random;

public class HasQuarterState implements State {

    transient GumballMachine gumballMachine;
    private static final long serialVersionUID = 4L;
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getSoldOutState());

    }

    @Override
    public void turnCrank() {
        System.out.println("You turned ...");
        int winner = randomWinner.nextInt(10);
        if ((winner==0)&&(gumballMachine.getCount()>1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
