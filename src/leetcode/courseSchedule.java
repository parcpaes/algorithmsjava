package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by parcpaes on 05/05/2018.
 */



public class courseSchedule {

    static class Solution{
        public  boolean visited[];
        public boolean previsited[];
        public LinkedList<Integer> adj[];
        public boolean cycle=true;
        public boolean dfs(int v){
            visited[v] = true;
            previsited[v]= true;
            for(Integer data:  adj[v] ){
                if(previsited[data]){
                    cycle=false;
                    return false;
                }
                if(!visited[data]) dfs(data);
            }
            previsited[v] =false;
            return cycle;
        }
        public boolean canFinish(int numCourses, int[][] prerequisites){
            adj = new LinkedList[numCourses];
            visited = new boolean[numCourses];
            previsited = new boolean[numCourses];
            for(int i=0;i<numCourses;i++)adj[i] = new LinkedList<>();
            Arrays.fill(visited, false);
            Arrays.fill(previsited, false);
            for(int i=0;i<numCourses;i++){
                adj[prerequisites[i][1]].add(prerequisites[i][0]);
            }
            return dfs(0);
        }
    }

    public static void main(String arg[]){
        Solution solve = new Solution();
    }
}

