import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IM extends UnicastRemoteObject
        implements IMInterface {

    public IM() throws RemoteException {
    }

    @Override
    public String registerUser(String u) throws RemoteException {
        return null;
    }

    @Override
    public void setClient(IMInterface c) throws RemoteException {

    }

    @Override
    public IMInterface getClient() throws RemoteException {
        return null;
    }

    @Override
    public void sendMessage() throws RemoteException {

    }
}
