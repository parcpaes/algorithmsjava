package spoj;

import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Disquery {
    public static class Edge{
        int from,to,weight;
        Edge(int source, int target,int w){
            this.from = source;
            this.to = target;
            this.weight = w;
        }
    }
    public static class Graph{
        LinkedList<Edge> adj[];
        public Graph(int n){
            adj = new LinkedList[n];
            for(int i=0;i<n;i++) adj[i] = new LinkedList<>();
        }
        public void add(int v, int u, int weight){
            adj[v].add(new Edge(v,u,weight));
            adj[u].add(new Edge(u,v,weight));
        }
        public Iterable<Edge> adj(int v){
            return adj[v];
        }
    }
    public static int table[][];
    public static int mini[][];
    public static int maxi[][];
    public static int par[][];
    public static void sparseTable(Object array[], int nx, int D){
        int maxk, n = array.length;
        maxk = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
        table = new int[maxk+1][n];
        for(int i=0;i<n;i++) table[0][i] = (int)array[i];
        for(int k=1;k<=maxk;k++){
            for(int j=0;j+(1<<k)<=n;j++){
                if(k<=D && j<nx){
                    int mid = par[k-1][j];
                    if(mid!=-1){
                        par[k][j] = par[k-1][mid];
                        mini[k][j]=Math.min(mini[k-1][j],mini[k-1][mid]);
                        maxi[k][j]=Math.max(maxi[k-1][j],maxi[k-1][mid]);
                    }
                }
                table[k][j] = Math.min(table[k-1][j], table[k-1][j+(1<<(k-1))]);
            }
        }
    }
    public static int querymin(int a, int b){
        int len = b-a+1;
        int k = Integer.numberOfTrailingZeros(Integer.highestOneBit(len));
        int m = b-(1<<k)+1;
        return Math.min(table[k][a],table[k][m]);
    }

    public static LinkedList<Integer> euler;
    public static LinkedList<Integer> previn;
    public static int indexs[];
    public static int depth[];
    public static void eulerdfs(Graph graph,int v, int u,int h){
        depth[v] = h;
        int newindex = previn.size();
        previn.add(v);
        indexs[v] = euler.size();
        euler.add(newindex);
        for(Edge edge: graph.adj(v)){
            if(edge.to != u){
                maxi[0][edge.to] = mini[0][edge.to]=edge.weight;
                par[0][edge.to] = v;
                eulerdfs(graph,edge.to,v,h+1);
                euler.add(newindex);
            }
        }
    }
    public static int maxk;
    public static int[] walk(int j,int k){
        int minx=1000005;
        int maxn=-1;
        for(int d=0;d<=maxk && j!=-1;d++){
            if(((1<<d)&k)>0){
                minx = Math.min(minx,mini[d][j]);
                maxn = Math.max(maxn,maxi[d][j]);
                j = par[d][j];
            }
        }
        return new int[]{minx, maxn};
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int N,a,b,weight,K,lca,left,right;
        while(in.hasNext()){
            N = in.nextInt();
            Graph graph = new Graph(N);
            indexs = new int[N];
            depth = new int[N];
            maxk = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));
            par = new int[maxk+1][N];
            mini = new int[maxk+1][N];
            maxi = new int[maxk+1][N];
            N = N -1;
            while(N-->0){
                a = in.nextInt()-1;
                b = in.nextInt()-1;
                weight = in.nextInt();
                graph.add(a,b,weight);
            }
            euler = new LinkedList<>();
            previn = new LinkedList<>();
            for(int d=0;d<=maxk;d++){
                Arrays.fill(par[maxk],-1);
                Arrays.fill(mini[maxk],1000005);
                Arrays.fill(maxi[maxk],-1);
            }
            K = in.nextInt();
            eulerdfs(graph,0,-1,0);
            sparseTable(euler.toArray(),indexs.length,maxk);
            while(K-->0){
                a = in.nextInt()-1;
                b = in.nextInt()-1;
                left = indexs[a];
                right = indexs[b];
                if(left>right){
                    int p = left;
                    left = right;
                    right = p;
                }
                lca = previn.get(querymin(left,right));
                int minmaxA[] = walk(a,depth[a]-depth[lca]);
                int minmaxB[] = walk(b,depth[b]-depth[lca]);
                System.out.println(Math.min(minmaxA[0],minmaxB[0])+" "+Math.max(minmaxA[1],minmaxB[1]));
            }
        }
    }
}
