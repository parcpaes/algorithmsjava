package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LCA {
    public static class Graph{
        private LinkedList<Integer> adj[];
        public Graph(int n){
            adj = new LinkedList[n];
            for(int i=0;i<n;i++) adj[i] = new LinkedList<>();
        }
        public void add(int v, int w){
            adj[v].add(w);
            adj[w].add(v);
        }
        public Iterable<Integer> adj(int v){
            return adj[v];
        }
    }
    public static int table[][];
    public static LinkedList<Integer> euler;
    public static LinkedList<Integer> prev;
    public static int indexes[];
    public static void sparseTable(Object array[]){
        int maxk,n = array.length;
        maxk = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
        table = new int[maxk+1][n];
        for(int i=0;i<n;i++) table[0][i] = (int)array[i];
        for(int k=1;k<=maxk;k++){
            for(int j=0;j+(1<<k)<=n;j++){
                table[k][j] = Math.min(table[k-1][j],table[k-1][j+(1<<(k-1))]);
            }
        }
    }
    public static int querymin(int a, int b){
        int len = b-a+1;
        int k = Integer.numberOfTrailingZeros(Integer.highestOneBit(len));
        int m = b-(1<<k)+1;
        return Math.min(table[k][a],table[k][m]);
    }
    public static void dfseuler(Graph graph,int v,int u){
        int newindex = prev.size();
        prev.add(v);
        indexes[v]=euler.size();
        euler.add(newindex);
        for(Integer w: graph.adj(v)){
            if(w!=u){
                dfseuler(graph,w,v);
                euler.add(newindex);
            }
        }
    }
    public static StringTokenizer st;
    public static BufferedReader br;
    public static String next(){
        while (st == null || !st.hasMoreElements())
        {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    public static void main(String arg[]){
        br = new BufferedReader(new InputStreamReader(System.in));

        int nt,N, M, a, b,Q;
        Graph graph;
        nt = Integer.parseInt(next());
        for(int i=1;i<=nt;i++){
            N = Integer.parseInt(next());
            graph = new Graph(N);
            for(int x=0;x<N;x++){
                M = Integer.parseInt(next());
                while(M-->0){
                    a = Integer.parseInt(next());
                    graph.add(x,a-1);
                }
            }
            indexes = new int[N];
            euler = new LinkedList<>();
            prev = new LinkedList<>();
            dfseuler(graph,0,-1);
            sparseTable(euler.toArray());
            Q = Integer.parseInt(next());
            System.out.printf("Case %d:\n",i);
            while(Q-->0){
                a = Integer.parseInt(next());
                b = Integer.parseInt(next());
                a = indexes[a-1];
                b = indexes[b-1];
                if(a>b){
                    int p = a;
                    a = b;
                    b = p;
                }
                System.out.println(prev.get(querymin(a,b))+1);
            }
        }
    }
}
