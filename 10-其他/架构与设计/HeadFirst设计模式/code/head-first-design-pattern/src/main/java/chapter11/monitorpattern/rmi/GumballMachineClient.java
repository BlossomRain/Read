package chapter11.monitorpattern.rmi;

import chapter11.monitorpattern.GumballMonitor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMachineClient {
    public static void main(String[] args){
        String[] machines = new String[]{
                "rmi://localhost:8848/machineA",
                "rmi://localhost:8848/machineB",
                "rmi://localhost:8848/machineC"};
        try {
            for (int i = 0; i < machines.length; i++) {
                GumballMachineRemote machineB =
                        (GumballMachineRemote) Naming.lookup(machines[i]);
                new GumballMonitor(machineB).report();
                System.out.println("----------------");
            }
//            GumballMachineRemote machineA = (GumballMachineRemote) Naming.lookup(machines[0]);
//
//            System.out.println(machineA.getClass());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
