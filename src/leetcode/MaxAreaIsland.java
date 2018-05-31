package leetcode;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 * Created by parcpaes on 10/05/2018.
 * 695 flood fill graph
 */
public class MaxAreaIsland {
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1, 0,-1};
    public static boolean visited[][];

    private static int floodfill(int x, int y, int[][] grid){
        if(x<0 || x>=grid.length || y<0 || y >= grid[0].length) return 0;
        if(grid[x][y]==0) return 0;
        if(visited[x][y]) return 0;
        visited[x][y] = true;
        int ans=1;
        for(int i=0;i<4;i++){
            ans += floodfill(x + dx[i], y+dy[i],grid);
        }
        return ans;
    }

    public static int maxAreaOfIsland(int[][] grid){
        visited = new boolean[grid.length][grid[0].length];
        int max=0, resul;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    resul = floodfill(i,j,grid);
                    max = Math.max(max,resul);
                }
            }
        }
        return max;
    }
    public static void main(String arg[]){
        int grid[][] = {
                {1,0,1,0},
                {1,0,0,0},
                {0,1,1,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,0,0,0},
                {0,0,1,1},
                {0,0,0,1}
        };
        TreeMap<Integer,int[]> treearray = new TreeMap<>();
        treearray.put(0,new int[]{2,5,6});

        TreeMap<Integer,Vector<Integer>> treeVector = new TreeMap<>();

        System.out.println(maxAreaOfIsland(grid));
    }
}
