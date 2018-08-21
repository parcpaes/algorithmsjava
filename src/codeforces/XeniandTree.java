package codeforces;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class XeniandTree {
    public static class Graph{
        public LinkedList<Integer> adj[];
        public Graph(int n){
            adj = new LinkedList[n];
            for(int v=0;v<n;v++) adj[v] = new LinkedList<>();
        }
        public void add(int v,int w){
            adj[v].add(w);
            adj[w].add(v);
        }
        public Iterable<Integer> adj(int s){
            return adj[s];
        }
    }
    public static int color[];
    public static final int ROSE = 1;
    public static int oo = 100000000;
    public static int subtree[];
    public static int N;
    public static int query(Graph graph,int u, int p){
        if(color[u] == ROSE) return 0;
        int min = oo;
        for(Integer v:graph.adj(u)){
            if(v!= p){
                int q = query(graph,v,u)+1;
                min = Math.min(min, q);
            }
        }
        return min;
    }
    private static void dfsSize(Graph graph,int u, int p){
        subtree[u] = 1;
        for(Integer v: graph.adj(u)){
            if(v!=p){
                dfsSize(graph,v,u);
                subtree[u] += subtree[v];
            }
        }
    }
    private static int cetroid(Graph graph, int u, int p){
        for(Integer v: graph.adj(u)){
            if(v!=p && subtree[v] > N/2) return cetroid(graph,v,u);
        }
        return u;
    }
    public static void update(int a){
        color[a] = ROSE;
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n,m,a,b,t,vi;
        while(in.hasNext()){
            n = in.nextInt();
            m = in.nextInt();
            Graph graph = new Graph(n+1);
            N = n;
            subtree = new int[n+1];
            color = new int[n+1];
            color[1]=1;
            n = n-1;
            while(n-->0){
                a = in.nextInt();
                b = in.nextInt();
                graph.add(a,b);
            }
            /*while(m-->0){
                t = in.nextInt();
                vi = in.nextInt();
                if(t == 1) update(vi);
                else System.out.println(query(graph,vi,-1));
            }*/
            dfsSize(graph,1,-1);
            System.out.println(cetroid(graph,1,-1));
        }
    }
}
