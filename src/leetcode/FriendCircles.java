package leetcode;

/**
 * Created by parcpaes on 30/04/2018.
 * 547
 */
public class FriendCircles {
    public static boolean[] visited;
    public static int comp;
    static void dfs(int M[][], int x){
        visited[x] = true;
        for(int i=0;i<M[x].length; i++){
            if(!visited[i] && M[x][i]==1){
                dfs(M,i);
            }
        }
    }
    public static int findCircleNum(int M[][]){
        int n = M[0].length;
        visited = new boolean[n];
        comp=0;
        for(int i=0;i<n;i++){
            if((!visited[i])){
                dfs(M,i);
                comp++;
            }
        }
        return comp;
    }
    public static void main(String arg[]){
        int matrix [][] = {
                {1,0,1,0,0},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,0,1,1,0},
                {0,0,0,0,1}
        };
        int valueint = 1000000000;
        long valuelong = 1000000000000000000L;
        short valueshort = 10000;
        byte valuebyte = 100;
        System.out.println(findCircleNum(matrix));
    }
}
