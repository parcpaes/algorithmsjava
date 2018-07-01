package leetcode;

import java.util.TreeSet;

//378
public class KthMatrix {
    public int kthSmallest(int [][]matrix, int k){
        return matrix[(k-1)%matrix.length][(k-1)/matrix.length];
    }
    public static void main(String arg[]){
        KthMatrix kthMatrix = new KthMatrix();
        int matrix [][]= {
                    {1, 2},
                    {1, 3},
        };
        System.out.println(kthMatrix.kthSmallest(matrix,2));
    }
}
