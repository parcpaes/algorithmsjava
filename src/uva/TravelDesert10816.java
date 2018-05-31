package uva;

import java.util.*;

//10816
public class TravelDesert10816 {

    public static class Edges implements Comparable<Edges>{
        public int from, to;
        public int weight ,temperature;
        Edges(int x, int y, int temperature, int weight){
            this.from = x;
            this.to = y;
            this.weight = weight;
            this.temperature = temperature;
        }

        @Override
        public int compareTo(Edges o) {
            if(this.temperature > o.temperature) return 1;
            if(this.temperature < o.temperature) return -1;
            return 0;
        }
    }
    public static class Pair implements Comparable<Pair>{
        public int from;
        public double weight;
        Pair(double weight, int from){
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.weight > o.weight) return 1;
            if(this.weight < o.weight) return -1;
            return 0;
        }
    }

    public static int disto[];
    private static Edges edgto[];
    private static LinkedList<Edges> adj[];
    private static boolean visited[];
    private static int source,oases;
    public static void initAdj(int n){
        adj = new LinkedList[n];
        edgto = new Edges[n];
        disto = new int[n];
        visited = new boolean[n];
        for(int i=1;i<n;i++){
            adj[i] = new LinkedList<>();
            disto[i] = Integer.MAX_VALUE;
        }
    }
    public static void reset(int n){
        for(int i=1;i<n;i++){
            disto[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
    }

   public static void dijkstra(int tempt){
        reset(oases+1);
        disto[source] = 0;
        PriorityQueue<Pair> minq = new PriorityQueue<>();
        minq.add(new Pair(disto[source],source));

        while(!minq.isEmpty()){
            Pair top = minq.poll();
            int from = top.from;
            if(visited[from]) continue;
            visited[from]=true;
            for(Edges ed: adj[from]){
                int to = ed.to;
                int weight = ed.weight;
                if((ed.temperature<=tempt) && (weight+disto[from] < disto[to])){
                    disto[to] = weight + disto[from];
                    minq.add(new Pair(disto[to], to));
                    edgto[to]=ed;
                }
            }
        }
    }
    public static void path(int target){
        if(edgto[target].from == source){
            System.out.printf("%d %d",edgto[target].from, edgto[target].to);
            return;
        }
        path(edgto[target].from);
        System.out.printf(" %d",edgto[target].to);
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int paths,target,low=0,high=0;
        while(in.hasNext()){
            oases = in.nextInt();
            paths = in.nextInt();
            source = in.nextInt();
            target = in.nextInt();
            initAdj(oases+1);
            low=0; high=0;
            while(paths-->0){
                int x = in.nextInt();
                int y = in.nextInt();
                int temp= (int)Math.floor(in.nextDouble()*10.0);
                int weight= (int)Math.floor(in.nextDouble()*10.0);
                adj[x].add(new Edges(x,y,temp,weight));
                adj[y].add(new Edges(y,x,temp,weight));
                high = Math.max(high,temp);
            }
            int ans = 0;

            while(low<=high){
                int mid= (low+high)>>1;
                dijkstra(mid);
                if(visited[target]){
                    high = mid-1;
                    ans = mid;
                }else{
                    low = mid+1;
                }
            }
            dijkstra(ans);
            path(target);
            System.out.printf("\n%d.%d %d.%d\n",disto[target]/10,disto[target]%10,ans/10,ans%10);
        }
    }
}
