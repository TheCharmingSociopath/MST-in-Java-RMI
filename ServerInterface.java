import java.rmi.* ;

public interface ServerInterface extends Remote{
    public void addGraph(String graph_id, int n) throws RemoteException;
    public void addEdge(String graph_id, int u, int v, int w) throws RemoteException;
    public int getMST(String graph_id) throws RemoteException;
}