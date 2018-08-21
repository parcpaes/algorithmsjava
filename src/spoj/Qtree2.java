package spoj;

import java.util.LinkedList;
import java.util.Scanner;

//Query on a tree II
public class Qtree2 {
    public static class Edge{
        int from, to, weight;
        Edge(int s, int t, int w){
            from = s;
            to = t;
            weight = w;
        }
    }
    private static LinkedList<Edge> adj[];
    private static int[] disto;
    private static int[] rank;
    private static int[] kth;
    private static boolean visited[];
    private static int k=0;
    public static void init(int n){
        int k=0;
        adj = new LinkedList[n];
        rank = new int[n];
        disto = new int[n];
        kth = new int[n];
        for(int i=1;i<n;i++) adj[i] = new LinkedList<>();
    }
    public static void dfs(int s){
        visited[s]=true;
        k++;
        for(Edge edge: adj[s]){
            int to = edge.to;
            if(!visited[to]){
                disto[to] = disto[edge.from]+edge.weight;
                rank[to] = rank[edge.from] + 1;
                kth[k] = edge.from;
                dfs(to);
            }
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int T, N, a,b,c;
        T = in.nextInt();
        while(T-->0){
            N = in.nextInt();
            int nn = N;
            init(N+1);
            while(N-->1){
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
                adj[a].add(new Edge(a,b,c));
                adj[b].add(new Edge(b,a,c));
            }

            while(true){
                String dis = in .next();
                a = in.nextInt();
                b = in.nextInt();
                visited = new boolean[nn+1];
                disto[a]=0;
                rank[a]=1;
                k=0;
                if(dis.equals("DIST")){
                    dfs(a);
                    System.out.println("d "+disto[b]);
                }else if(dis.equals("KTH")){
                    int kn = in.nextInt();
                    System.out.println("kth "+kth[kn]);
                }
            }
        }
    }
}
