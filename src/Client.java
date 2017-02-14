import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            IMInterface stub = (IMInterface) registry.lookup("Hello");
            // create a scanner so we can read the command-line input
            Scanner scanner = new Scanner(System.in);

            //  prompt for the user's name
            System.out.print("Enter a command: ");

            // get their input as a String
            String command = scanner.next().toLowerCase();

            switch (command) {
                case "register-name":
                    System.out.print("Enter your user name: ");
                    String name = scanner.next();
                    String response = stub.registerUser(name);
                    System.out.println("response: " + response);
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}