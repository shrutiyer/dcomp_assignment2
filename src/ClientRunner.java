import java.rmi.*;
import java.util.*;

public class ClientRunner {
    private static ClientInterface registerClient(Scanner s, ServerInterface server) throws RemoteException {
        while (true) {
            System.out.println("Enter Your name and press Enter:");
            String name=s.nextLine().trim();
            ClientInterface client = new Client(name);
            if (server.register(client)) {
                System.out.println("Successfully registered.");
                return client;
            }
            System.out.print("Username is already taken. ");
        }
    }

    public static void main (String[] argv) {
        try {

            Scanner s=new Scanner(System.in);

            ServerInterface server = (ServerInterface)Naming.lookup("rmi://localhost/ABC");
            ClientInterface client = registerClient(s, server);

            boolean quit = false;

            while (!quit) {
                System.out.println("Here are the set of commands.\nEnter 1 to get a list of users.\nEnter 2 for sending a message to a user.\nEnter 3 to quit the application.");
                int msg = Integer.parseInt(s.nextLine().trim());

                switch (msg) {
                    case 1:
                        for (String str : server.getUsers()) {
                            System.out.println(str);
                        }
                        break;
                    case 2:
                        System.out.println("Enter the username of the receiver");
                        String r = s.nextLine().trim();
                        System.out.println("Enter the message.");
                        String m = s.nextLine().trim();
                        Message sendMsg = new Message(client.getName(), r, m);
                        System.out.println(sendMsg);
                        boolean success = server.sendToServer(sendMsg);
                        if (!success) System.out.println("Unable to sendToClient message.");
                        break;
                    case 3:
                        quit = true;
                }
            }
        }catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
        }
    }
}