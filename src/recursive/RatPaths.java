package recursive;

/**
 * Created by parcpaes on 09/04/2018.
 */
import java.util.*;
public class RatPaths {

    public boolean isSafe(int m[][], int x, int y){
        return (x>=0 && y >=0 && x < m[0].length && y < m[0].length && m[x][y] == 1);
    }

    public static ArrayList<String> printPath(int[][] m, int n)
    {
        //Your code here
        return null;
    }


    public static void printRat(int m[][]){
        for(int i=0;i < m[0].length; i++){
            for(int j=0; j< m[0].length; j++){
                System.out.print(" "+m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while(t-->0){
            int n = Integer.parseInt(in.nextLine());
            String cad = in.nextLine();
            String numbers[] = cad.split("\\s+");
            int m [][] = new int[n][n];
            for(int i=0; i< numbers.length; i++){
                m[i/n][i%n] = Integer.parseInt(numbers[i]);
            }
            printRat(m);
        }
    }
}
