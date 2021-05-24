import java.util.*;

class Graph{
    static class Edge implements Comparable<Edge>{
        int u, v, w;

        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge edge){
            if(this.w<edge.w) return -1;
            else if(this.w>edge.w) return 1;
            return 0;
        }
    }

    private ArrayList<Edge> edge_list;
    private int num_nodes;

    Graph(int n){
        this.num_nodes = n;
        this.edge_list = new ArrayList<Edge>();
    }

    public void addEdge(int u, int v, int w){
        Edge edge = new Edge(u, v, w);
        this.edge_list.add(edge);
    }

    public int getMST(){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(this.edge_list);
        DSU dsu = new DSU(this.num_nodes);
        int done_count = 0, mst_weight = 0;

        while(pq.isEmpty() == false){
            Edge edge = pq.poll();
            if(dsu.getParent(edge.u) == dsu.getParent(edge.v)) continue;
            dsu.join(edge.u, edge.v);
            
            mst_weight += edge.w;
            ++done_count;      
        }
        if(done_count==this.num_nodes-1) return mst_weight;
        else return -1;
    }
}