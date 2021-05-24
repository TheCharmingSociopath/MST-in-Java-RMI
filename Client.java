import java.util.Scanner;
import java.rmi.registry.*;

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
      try {
         String host = args[0];
         int port = Integer.parseInt(args[1]);
         
         Registry registry = LocateRegistry.getRegistry(host, port);
         ServerInterface stub = (ServerInterface) registry.lookup("server");
         
         Scanner input = new Scanner(System.in);
         while(input.hasNext()){
            String op = input.next(), graph_id = input.next();
            if(op.equals("add_graph")){
               stub.addGraph(graph_id, input.nextInt());
            }
            else if(op.equals("add_edge")){
               stub.addEdge(graph_id, input.nextInt(), input.nextInt(), input.nextInt());
            }
            else if(op.equals("get_mst")){
               System.out.println(stub.getMST(graph_id));
            }
         }
         input.close();
         
      } catch (Exception e) {
         System.err.println("Client side exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}