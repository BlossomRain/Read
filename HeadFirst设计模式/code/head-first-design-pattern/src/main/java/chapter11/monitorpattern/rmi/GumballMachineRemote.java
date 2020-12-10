package chapter11.monitorpattern.rmi;

import chapter10.statepattern.State;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Serializable, Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
