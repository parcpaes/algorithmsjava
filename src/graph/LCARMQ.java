package graph;

import jdk.nashorn.internal.runtime.arrays.IteratorAction;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class LCARMQ {
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
        public Iterable<Integer> adj(int s){
            return adj[s];
        }
    }
    public static int table[][];
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
        return Math.min(table[k][a], table[k][m]);
    }
    public static LinkedList<Integer> euler = new LinkedList<>();
    public static LinkedList<Integer> newOld = new LinkedList<>();
    public static int index[];
    public static int array[];
    public static void dfs(Graph graph, int v, int u,int h){
        int newindex = newOld.size();
        newOld.add(v);
        index[v] = euler.size();
        euler.add(newindex);
        for(Integer w:graph.adj(v)){
            if(w!=u){
                dfs(graph,w,v,h+1);
                euler.add(newindex);
            }
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        Graph graph = new Graph(10);
        index = new int[10];
        graph.add(0,5);
        graph.add(5,7);
        graph.add(7,2);
        graph.add(5,1);
        graph.add(1,3);
        graph.add(1,6);
        graph.add(5,8);
        graph.add(0,9);
        graph.add(9,4);
        dfs(graph,0,-1,0);
        sparseTable(euler.toArray());
        while(true){
            int left = in.nextInt();
            int right = in.nextInt();
            left = index[left];
            right = index[right];
            int index = querymin(left,right);
            System.out.println(newOld.get(index));
        }
    }
}
