import java.rmi.server.UnicastRemoteObject; 
import java.rmi.registry.*;

public class Server extends RemoteClass {
    public Server() {}
    public static void main(String args[]) {
        try{
            System.setProperty("java.rmi.server.hostname","0.0.0.0");
            int port = Integer.parseInt(args[0]);
            Registry registry = LocateRegistry.createRegistry(port);
            RemoteClass obj = new RemoteClass();
            ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(obj, 0);
            
            registry.bind("server", stub);  
            System.err.println("Server is Ready");

        } catch (Exception e) {
            System.err.println("Server side exception: " + e.toString());
            e.printStackTrace();
        }

    }
}