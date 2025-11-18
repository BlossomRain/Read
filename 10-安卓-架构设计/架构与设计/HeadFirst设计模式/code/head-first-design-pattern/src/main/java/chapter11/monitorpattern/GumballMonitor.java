package chapter11.monitorpattern;

import chapter11.monitorpattern.rmi.GumballMachineRemote;

import java.rmi.RemoteException;

public class GumballMonitor {
    GumballMachineRemote gumballMachine;

    public GumballMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report() throws RemoteException {
        System.out.println("Gumball Machine:"+gumballMachine.getLocation());
        System.out.println("current inventory:"+gumballMachine.getCount()+"gumballs");
        System.out.println("current state:"+gumballMachine.getState());
    }
}
