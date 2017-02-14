import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class Server implements IMInterface {

    private Set<String> users;
    public Server() {
        users = new HashSet<>();
    }

    @Override
    public String registerUser(String user_name) {
        if (users.contains(user_name))
            return "Username already in use. Try again!";
        users.add(user_name);
        return "User successfully registered!";
    }

    public static void main(String args[]) {

        try {
            System.setProperty("java.rmi.server.hostname","10.26.90.131");
            Server obj = new Server();
            IMInterface stub = (IMInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
