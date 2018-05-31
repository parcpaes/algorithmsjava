package leetcode;

import java.util.*;


/**
 * Created by parcpaes on 11/05/2018.
 */
public class graphBipartite {
    public static Map<Integer,Integer> colors = new HashMap<>();
    public static boolean bfs(int s, int[][] graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        colors.put(s,1);
        while(!queue.isEmpty()){
            int vertex = queue.remove();
            for(int i=0;i < graph[vertex].length;i++){
                if(colors.get(graph[vertex][i])==null){
                    queue.add(graph[vertex][i]);
                    int c = (colors.get(vertex)==1)? 2: 1;
                    colors.put(graph[vertex][i],c);
                }else if(colors.get(vertex) == colors.get(graph[vertex][i])){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph){
        colors.clear();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(colors.get(graph[i][j])==null){
                    if(!bfs(i,graph))return false;
                }
            }
        }
        return true;
    }

    public static void main(String arg[]){
        int graph[][] = {
                {1,2},
                {0,2},
                {0,1},
                {4,5},
                {3,5},
                {3,4},
                {7,8},
                {6},
                {6},
                {},
                {11},
                {10},
                {14},
                {},
                {12},
                {16},
                {15},
                {},
                {19,20},
                {18,20},
                {18,19},
                {22,23},
                {21,23},
                {21,22},
                {25,26},
                {24,26},
                {24,25},
                {},
                {29},
                {28}
        };

        System.out.println(isBipartite(graph));
    }
}
