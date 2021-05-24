import java.util.HashMap;

public class RemoteClass implements ServerInterface {
    private HashMap<String, Graph> graph_map;
    
    RemoteClass(){
        graph_map = new HashMap<String, Graph>();
    }
    public void addGraph(String graph_id, int n){
        Graph graph = new Graph(n);
        this.graph_map.put(graph_id, graph);
    }

    public void addEdge(String graph_id, int u, int v, int w) {
        Graph graph = this.graph_map.get(graph_id);
        graph.addEdge(u, v, w);
    }
    
    public int getMST(String graph_id){
        return this.graph_map.get(graph_id).getMST();
    }
}