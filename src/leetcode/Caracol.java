package leetcode;

/**
 * Created by parcpaes on 09/05/2018.
 */
public class Caracol {
    public static void print(int matrix[][]){
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String arg[]){
        int n=4;
        int x=1;
        int[][] M = new int[n + 1][n + 1];
        for (int a = 1; a <= n / 2; a++) {
            for (int i = a; i <= n - a; i++) {
                M[i][a] = x;
                x++;
            }
            for (int i = a; i <= n - a; i++) {
                M[n - a + 1][i] = x;
                x++;
            }
            for (int i = n - a + 1; i >= a + 1; i--) {
                M[i][n - a + 1] = x;
                x++;
            }
            for (int i = n - a + 1; i >= a + 1; i--) {
                M[a][i] = x;
                x++;
            }
        }
        if (n % 2 == 1) {
            M[n / 2 + 1][n / 2 + 1] = x;
        }
        print(M);
    }
}
