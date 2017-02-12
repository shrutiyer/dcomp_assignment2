package example.instant;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InstantMessage extends Remote {
    String sayHello() throws RemoteException;
}