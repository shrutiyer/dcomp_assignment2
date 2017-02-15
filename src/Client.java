import java.rmi.*;
import java.rmi.server.*;

public class Client extends UnicastRemoteObject implements ClientInterface {

    public String name;

    public Client(String n)  throws RemoteException {
        this.name=n;
    }
    public String getName() throws RemoteException {
        return this.name;
    }

    public void sendToClient(Message m) throws RemoteException{
        System.out.println(m.sender + ": " + m.msg);
    }
}