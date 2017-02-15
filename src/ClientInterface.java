import java.rmi.*;

public interface ClientInterface extends Remote{
    public String getName() throws RemoteException;
    public void send(Message msg) throws RemoteException;
}