package chapter11.monitorpattern;

import chapter10.statepattern.GumballMachine;
import chapter11.monitorpattern.rmi.GumballMachineRemote;

import java.rmi.RemoteException;

public class GumballMachineTest {
    public static void main(String[] args){
        try {
            GumballMachineRemote machine = new GumballMachine(112, "Seattle");
            GumballMonitor monitor = new GumballMonitor(machine);
            monitor.report();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
