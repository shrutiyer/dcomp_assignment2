import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Server extends UnicastRemoteObject implements ServerInterface{
    private Set<ClientInterface> clients = new HashSet<>();
    private Map<String,ClientInterface> clientMap= new HashMap<>();

    protected Server() throws RemoteException {
    }

    @Override
    public boolean register(ClientInterface client) throws RemoteException {
        if (clientMap.keySet().contains(client.getName())) {
            return false;
        }
        clients.add(client);
        clientMap.put(client.getName(), client);
        return true;
    }

    @Override
    public List<String> getUsers() throws RemoteException {
        System.out.println("Request for user received");
        ArrayList<String> clientList = new ArrayList<>();
        for (ClientInterface c: clients) {
            clientList.add(c.getName());
        }
        return clientList;
    }

    @Override
    public boolean sendToServer(Message m) throws RemoteException {
        System.out.println("Server message received");
        if(!clientMap.keySet().contains(m.receiver)) {
            return false;
        }
        clientMap.get(m
                .receiver).sendToClient(m);
        return true;
    }

}
