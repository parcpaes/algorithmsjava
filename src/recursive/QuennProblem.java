package recursive;
import java.util.*;
/**
 * Created by parcpaes on 27/03/2018.
 */

public class QuennProblem {
    final int N= 4;
    void printSolution(int board[][]){
        for(int i=0; i< N;i++){
            for(int j=0; j < N; j++){
                System.out.print(" " +board[i][j]);
            }
            System.out.println();
        }
    }
    boolean isSafe(int board[][], int row, int col){
        int i,j;

        //check this row on left side
        for(i=0;i<col; i++) {
            if (board[row][i] == 1) return false;
        }

        //check upper diagonal on left side
        for(i=row, j=col ; i>=0 && j>=0; i--, j--){
            if(board[i][j] ==1 ) return false;
        }

        //check lower diagonal on left side
        for(i=row, j=col; j>=0 && i<N; i++, j--){
            if(board[i][j] == 1) return false;
        }
        return true;
    }

    boolean solveQueen(int board[][], int col){
        if(col>=N) return true;

        for(int i=0;i< N; i++){
            if(isSafe(board, i,col)){
                board[i][col] = 1;

                if(solveQueen(board, col+1))  return true;

                board[i][col] =0;
            }
        }
        return false;
    }
    public static void main(String arg[]){
        QuennProblem queen = new QuennProblem();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int board[][] = new int[n][n];

        if(!queen.solveQueen(board,0)){
            System.out.println("Solution does not exist");
        }
        queen.printSolution(board);
    }
}
