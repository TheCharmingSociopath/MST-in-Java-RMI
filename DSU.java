public class DSU{
    Integer[] parent;
    int num_nodes;

    DSU(int n){
        this.num_nodes = n;
        this.parent = new Integer[n+10];
        for(int i=0;i<=n;++i) this.parent[i] = i;
    }

    public int getParent(int n){
        int cur = n;
        while(this.parent[cur]!=cur) 
            cur=this.parent[cur];
            
        while(this.parent[n]!=n){
            int t = this.parent[n];
            this.parent[n] = cur;
            n = t;
        }
        return cur;
    }

    public void join(int a, int b){
        int pa = this.getParent(a), pb = this.getParent(b);
        if(this.getParent(pa) == this.getParent(pb)) return;
        this.parent[pb] = pa;
        return;
    }
}