package graph;

import java.util.LinkedList;

public class Graph{
    private int V;// number of vertices
    private int E;//  number of edges
    private LinkedList<Integer>[] adj;
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for(int v = 0;v<V;v++)
            adj[v] = new LinkedList<>();
    }
    public int V(){ return V;}
    public int E(){ return E;}
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public int degree(int v){
        int degree = 0;
        for(int w: adj[v]) degree++;
        return degree;
    }
    public int maxDegree(){
        int max=0;
        for(int v=0;v<V;v++){
            int d = degree(v);
            if(d > max) max = d;
        }
        return max;
    }
    public String toString(){
        String s = V + " vertices , "+E+" edges\n";
        for(int v=0;v<V;v++){
            s += v + ": ";
            for(int w : adj[v])
                s+= w +" ";
            s +="\n";
        }
        return s;
    }
}
