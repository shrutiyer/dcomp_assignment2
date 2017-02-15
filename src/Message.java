import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Message implements Serializable {
    String sender, receiver, msg;

    public Message (String s, String r, String m) throws RemoteException {
        super();
        this.sender = s;
        this.receiver = r;
        this.msg = m;
    }

    @Override
    public String toString() {
        return "Message from " + sender + " to " + receiver + ". " + msg;
    }
}
