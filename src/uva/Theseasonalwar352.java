package uva;

import java.util.Scanner;


public class Theseasonalwar352 {
    public static char label[][];
    public static boolean visited[][];
    public static int dx[]={1 ,1 ,0,-1,-1,-1, 0, 1};
    public static int dy[]={0 ,1 ,1, 1, 0,-1,-1,-1};
    public static int dfs(int x,int y){
        if(x < 0 || x >= visited.length || y < 0 || y >= visited.length) return 0;
        if(label[x][y] != '1') return 0;
        if(visited[x][y]) return 0;
        int ans = 1;
        visited[x][y] = true;
        for(int k=0; k<8; k++){
            ans += dfs(x+dx[k], y +dy[k]);
        }
        return ans;
    }

    public static void main(String arg[]){
        Scanner in= new Scanner(System.in);
        int n,t=1;
        while(in.hasNext()){
            n = Integer.parseInt(in.next());
            label = new char[n][n];
            visited = new boolean[n][n];
            for(int i=0; i<n; i++){
                label[i] = in.next().toCharArray();
            }

            int amount = 0;
            for(int i=0; i<label.length; i++){
                for(int j=0; j < label.length; j++){
                    if(label[i][j]!='0' && !visited[i][j]){
                        int resul = dfs(i,j);
                        //System.out.printf("%d\n",resul);
                        if(resul>0) amount++;
                    }
                }
            }
            System.out.printf("Image number %d contains %d war eagles.\n", t,amount);
            t++;
        }
    }
}