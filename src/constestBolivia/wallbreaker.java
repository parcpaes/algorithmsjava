package constestBolivia;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by parcpaes on 21/09/2017.
 */
public class wallbreaker {
    public static char[][] village;
    public static boolean[] visited;
    public static void dfs(int s){
        visited[s] = true;
        for(int i= 0; i<village[s].length; i++){
            if(village[s][i] != '*' && (!visited[i])){
                dfs(i);
            }
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Input is a file
        } else {
             //in = new Scanner(System.in);
        }
        int n = Integer.parseInt(in.next());
        int m=  Integer.parseInt(in.next());
        m = m+2;
        n = n +2;

        village = new char[n][m];
        visited = new boolean[n*m];

        Arrays.fill(village[0], '.');
        for (int i=1; i<m-1; i++){
            String cad = "."+in.next()+".";
            village[i] = cad.toCharArray();
        }
        Arrays.fill(village[n-1], '.');
        dfs(0);
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(visited[j]+" ");
            }
            System.out.println();
        }
    }
}
