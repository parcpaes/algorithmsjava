package trees;

import graph.Graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean hasCycle;
    public DepthFirstSearch(Graph G){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
    }
    private void dfs(Graph G, int v,int u){
        marked[v]=true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w,v);
            }else if(w!=u){
                hasCycle = true;
            }
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }
    public static void main(String arg[]){
        Graph graph = new Graph(4);
        DepthFirstSearch depthFS = new DepthFirstSearch(graph);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        depthFS.dfs(graph,0,0);
        System.out.println(depthFS.hasCycle());
    }
}
