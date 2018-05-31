package leetcode;

import java.util.HashMap;
import java.util.Map;

//130
public class SurroundedRegions {
    public static int dx[]={1,0,-1,0};
    public static int dy[]={0,1,0,-1};
    public static boolean visited[][];
    public static void floodfillBoard(int x,int y, char[][] board){
        if(x<0|| x>=board.length || y<0 || y>=board[0].length) return;
        if(board[x][y]=='X') return;
        if(visited[x][y]) return;
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            floodfillBoard(x+dx[i],y+dy[i],board);
        }
    }
    public static void solve(char[][] board){
        if(board.length==0) return;
        visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            floodfillBoard(i,0,board);
            floodfillBoard(board.length-i-1,board[0].length-1,board);
        }
        for(int j=1;j<board[0].length-1;j++){
            floodfillBoard(0,j,board);
            floodfillBoard(board.length-1,board[0].length-1-j,board);
        }
        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(!visited[i][j] && board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    public static void main(String arg[]){
        char boards[][] = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };

        solve(boards);
        for(int i=0;i<boards.length;i++){
            for(int j=0;j<boards[0].length;j++){
                System.out.print(boards[i][j]+" ");
            }
            System.out.println();
        }
    }
}
