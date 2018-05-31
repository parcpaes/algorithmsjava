package leetcode;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by parcpaes on 09/05/2018.
 * 766
 */
public class TopelizMarix {
    public static boolean isTopelizMatrix(int[][] matrix){
        if(matrix[0].length == 1) return true;
        if(matrix.length == 1) return true;
        int col = matrix[0].length;
        int row = matrix.length;
        int max=0,j,i;
        int val=0;
        TreeSet<Integer> same= new TreeSet<>();
        col = (row>col)? col: row;
        for(i=0;i<row;i++){
            for(j=0;j<col-max;j++){
                 same.add(matrix[j+i][j]);
            }
            if(same.size()>1) return false;
            same.clear();
            if((j+i)==row)max++;
        }
        max=0;
        row = (row>=matrix[0].length)? matrix[0].length-1: row;
        for(j=1;j<matrix[0].length;j++){
            for(i=0;i<row-max;i++){
                same.add(matrix[i][i+j]);
            }
            if(same.size()>1) return false;
            same.clear();
            if((i+j)==matrix[0].length) max=max+1;
        }
        return true;
    }
    public static void main(String arg[]){
        int matrix[][] = {
                {1,2,3,4,10},
                {9,1,2,3,4}
        };
        System.out.println(isTopelizMatrix(matrix));
    }
}
