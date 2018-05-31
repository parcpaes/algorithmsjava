package graph;

import java.util.LinkedList;

public class EdgeWeightedDigraph {
    private final int V;
    private final LinkedList<DirectedEdge> adj[];
    public EdgeWeightedDigraph(int V){
        this.V=V;
        adj= new LinkedList[V];
        for(int v=0;v<V;v++){
            adj[v] = new LinkedList<>();
        }
    }
    public void addEdge(DirectedEdge e){
        int v= e.from();
        adj[v].add(e);
    }
    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }
}
