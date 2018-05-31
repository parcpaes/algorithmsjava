package leetcode;

/**
 * Created by parcpaes on 10/05/2018.
 * //200 Number of Islands graph
 */
public class NumberIslands {
    public static int dx[]={1,0,-1,0};
    public static int dy[]={0,1, 0,-1};

    public static void floodFill(int x, int y, char grid[][]){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return;
        if(grid[x][y]=='0') return;
        grid[x][y] = '0';
        for(int i=0;i<4;i++){
            floodFill(x+dx[i], y+dy[i],grid);
        }
    }

    public static int numIsLands(char[][] grid){
        if(grid.length==0) return 0;
        int components=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    floodFill(i,j,grid);
                    components++;
                }
            }
        }
        return components;
    }
    public static void main(String arg[]){
        char grid [][] = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','0','0','0'},
                {'0','0','0','1','0'},
                {'1','0','1','1','1'},
                {'1','0','0','1','0'},
                {'1','1','1','0','0'}};
        System.out.println(numIsLands(grid));
    }
}
