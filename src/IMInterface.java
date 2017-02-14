import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMInterface extends Remote {
    String registerUser(String u) throws RemoteException;
    public void setClient(IMInterface c)throws RemoteException;
    public IMInterface getClient() throws RemoteException;
    public void sendMessage() throws RemoteException;
}