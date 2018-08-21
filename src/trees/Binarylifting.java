package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Binarylifting{
    public static int N,D;
    public static LinkedList<Integer> adj[];
    public static int depth[];
    public static int par[][];
    public static void dfs(int v,int u,int h){
        depth[v]=h;
        for(Integer w:adj[v]) if(w!=u) {
            par[0][w] = v;
            dfs(w,v,h+1);
        }
    }
    public static void binarylifting(int n){
        par = new int[D+1][n];
        for(int dd[]: par){
            Arrays.fill(dd,-1);
        }
        for(int d=1;d<=D;d++){
            for(int j=0;j<n;j++){
                int mid = par[d-1][j];
                if(mid !=-1) par[d][j]=par[d-1][mid];
            }
        }
    }
    public static int walk(int i, int k){
        for(int d=0;d<=D && i!=-1; d++){
            if(((1<<d) & k)>0)
                i = par[d][i];
        }
        return i;
    }
    public static int lca(int i,int j){
        if(depth[i]>depth[j]){
            i = walk(i,depth[i]-depth[j]);
        }
        if(depth[j]>depth[i]){
            j = walk(j,depth[j]-depth[i]);
        }
        if(i==j) return i;
        for(int d=D;d>=0;d--){
            if(par[d][i] != par[d][j]){
                i = par[d][i];
                j = par[d][j];
            }
        }
        return par[0][i];
    }
    public static int dist(int i,int j){
        return depth[i] + depth[j] - 2*depth[lca(i,j)];
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for(int i=0;i<N;i++) adj[i] = new LinkedList<>();

        for(int e=1;e<N;e++){
            int i=in.nextInt()-1;
            int j=in.nextInt()-1;
            adj[i].add(j);
            adj[j].add(i);
        }
        D = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));
        dfs(0,-1,0);
        binarylifting(N);
        long res= 0;
        for(int i=1;i<=N;i++){
            for(int j=i;j<=N;j+=i){
                res = dist(i-1,j-1)+1;
            }
        }
        System.out.println(res);
    }
}
