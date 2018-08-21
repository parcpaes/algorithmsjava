package URI;

import java.io.*;
import java.util.*;

public class ImperialRoad {
    public static class Union {
        public int parent[];
        public int weight[];

        public Union(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean unionset(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) return false;
            if (weight[root1] > weight[root2]) {
                parent[root2] = root1;
                weight[root1] += weight[root2];
            } else {
                parent[root1] = root2;
                weight[root2] += weight[root1];
            }
            return true;
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int from, to, weight;

        public Edge(int source, int target, int w) {
            this.from = source;
            this.to = target;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight > o.weight) return 1;
            if (this.weight < o.weight) return -1;
            return 0;
        }
    }

    public static class Graph {
        private LinkedList<Edge> sets[];
        public Graph(int n) {
            sets = new LinkedList[n];
            for (int i = 0; i < n; i++) sets[i] = new LinkedList<>();
        }

        public void addEdge(int v, int u, int w) {
            sets[v].add(new Edge(v, u, w));
            sets[u].add(new Edge(u, v, w));
        }

        public Iterable<Edge> adj(int v) {
            return sets[v];
        }
    }

    public static int table[][];
    public static int maxi[][];
    public static int par[][];
    public static int rows;

    public static void sparseTable(Object array[], int nx) {
        int maxk, n = array.length;
        maxk = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
        table = new int[maxk + 1][n];
        for (int i = 0; i < n; i++) table[0][i] = (int) array[i];
        for (int k = 1; k <= maxk; k++) {
            for (int j = 0; j + (1 << k) <= n; j++) {
                if (k <= rows && j < nx) {
                    int mid = par[k - 1][j];
                    if (mid != -1) {
                        par[k][j] = par[k - 1][mid];
                        maxi[k][j] = Math.max(maxi[k - 1][j], maxi[k - 1][mid]);
                    }
                }
                table[k][j] = Math.min(table[k - 1][j], table[k - 1][j + (1 << (k - 1))]);
            }
        }
    }

    public static int minquery(int a, int b) {
        int len = b - a + 1;
        int k = Integer.numberOfTrailingZeros(Integer.highestOneBit(len));
        int m = b - (1 << k) + 1;
        return Math.min(table[k][a], table[k][m]);
    }

    public static LinkedList<Integer> euler;
    public static LinkedList<Integer> previndex;
    public static int high[];
    public static int indexs[];
    public static Graph treed;

    public static void dfseuler(Graph graph, int v, int u, int h) {
        int newindex = previndex.size();
        previndex.add(v);
        indexs[v] = euler.size();
        euler.add(newindex);
        high[v] = h;
        for (Edge edge : graph.adj(v)) {
            if (edge.to != u) {
                par[0][edge.to] = v;
                maxi[0][edge.to] = edge.weight;
                dfseuler(graph, edge.to, v, h + 1);
                euler.add(newindex);
            }
        }
    }

    public static int mstkruskal(PriorityQueue<Edge> graphEdges, int n) {
        int mincost = 0;
        Union unio = new Union(n + 1);
        treed = new Graph(n);
        int v, w, weight;
        while (!graphEdges.isEmpty()) {
            Edge edge = graphEdges.poll();
            v = edge.from;
            w = edge.to;
            weight = edge.weight;
            if (unio.unionset(v, w)) {
                treed.addEdge(v, w, weight);
                mincost += weight;
            }
        }
        return mincost;
    }

    public static int walk(int a, int k) {
        int maxedge = -1;
        for (int d = 0; d <= rows && a != -1; d++) {
            if (((1 << d) & k) > 0) {
                maxedge = Math.max(maxedge, maxi[d][a]);
                a = par[d][a];
            }
        }
        return maxedge;
    }

    public static class Pair implements Comparable<Pair> {
        public int from, to;

        public Pair(int s, int t) {
            this.from = s;
            this.to = t;
        }

        @Override
        public int compareTo(Pair o1) {
            if (this.from == o1.from) return o1.to - this.to;
            else return o1.from - this.from;
        }
    }

    public static void main(String arg[]) throws IOException{
        InputStream inputStream = System.in;
        Scanner in = new Scanner(inputStream);
        int N, R, a, b, c, Query;
        while(in.hasNext()){
            N = Integer.parseInt(in.next());
            R = Integer.parseInt(in.next());
            rows = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));
            PriorityQueue<Edge> edges = new PriorityQueue<>();
            TreeMap<Pair, Integer> edgesIndex = new TreeMap<>();
            for(int i=0;i<R;i++) {
                a = Integer.parseInt(in.next()) - 1;
                b = Integer.parseInt(in.next()) - 1;
                c = Integer.parseInt(in.next());
                edges.add(new Edge(a, b, c));
                a = Math.min(a, b);
                b = Math.max(a, b);
                edgesIndex.put(new Pair(a, b), c);
            }
            indexs = new int[N];
            high = new int[N];
            par = new int[rows + 1][N];
            maxi = new int[rows + 1][N];
            for (int d = 0; d <= rows; d++) {
                for (int j = 0; j < N; j++) {
                    par[d][j] = -1;
                    maxi[d][j] = -1;
                }
            }
            euler = new LinkedList<>();
            previndex = new LinkedList<>();
            int mincost = mstkruskal(edges, N);
            dfseuler(treed, 0, -1, 0);
            sparseTable(euler.toArray(), N);
            Query = Integer.parseInt(in.next());
            while (Query-- > 0) {
                a = Integer.parseInt(in.next()) - 1;
                b = Integer.parseInt(in.next()) - 1;
                int left = indexs[a];
                int right = indexs[b];
                if (left > right) {
                    int p = left;
                    left = right;
                    right = p;
                }
                int lca = previndex.get(minquery(left, right));
                int maxA = walk(a, high[a] - high[lca]);
                int maxB = walk(b, high[b] - high[lca]);
                a = Math.min(a, b);
                b = Math.max(a, b);
                int roadadd = edgesIndex.get(new Pair(a, b));
                System.out.println(mincost + roadadd - Math.max(maxA, maxB));
            }
        }
    }
}
