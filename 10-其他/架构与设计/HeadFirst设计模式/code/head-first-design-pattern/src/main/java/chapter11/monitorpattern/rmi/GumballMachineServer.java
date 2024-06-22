package chapter11.monitorpattern.rmi;

import chapter10.statepattern.GumballMachine;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class GumballMachineServer {
    public static void main(String[] args){
        try {
            LocateRegistry.createRegistry(8848);
            Naming.rebind("rmi://localhost:8848/machineA",new GumballMachine(112,"Seattle"));
            Naming.rebind("rmi://localhost:8848/machineB",new GumballMachine(12,"Alaska"));
            Naming.rebind("rmi://localhost:8848/machineC",new GumballMachine(11,"California"));
            System.out.println("Regist OK...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
