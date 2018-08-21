package graph;

import java.util.LinkedList;

public class GraphHeigh {
    public static class Graph{
        private LinkedList<Integer> adj[];
        Graph(int n){
            adj = new LinkedList[n];
            for(int i=0;i<n;i++){
                adj[i] = new LinkedList<>();
            }
        }
        public void add(int v, int u){
            adj[v].add(u);
            adj[u].add(v);
        }
        public Iterable<Integer> adj(int v){
            return adj[v];
        }
    }
    public static boolean visited[];
    private static int diameter = 0;
    public static int dfsHeigt(Graph graph,int v, int u){
        int h1=0,h2=0;
        visited[v]=true;
        for(Integer w: graph.adj(v)){
            if(!visited[w] && w!=u){
                int h = dfsHeigt(graph,w,v)+1;
                if(h > h1){
                    h2 = h1;
                    h1 = h;
                }else if(h > h2){
                    h2 = h;
                }
            }
        }
        diameter = Math.max(diameter, h1+h2);
        return h1;
    }
    public static void main(String arg[]){
        Graph graph = new Graph(8);
        visited = new boolean[8];
        graph.add(0,1);
        graph.add(1,2);
        graph.add(2,3);
        graph.add(2,4);
        graph.add(1,5);
        graph.add(5,6);
        System.out.println(dfsHeigt(graph,0,0));
        System.out.println(diameter);
    }
}
