package spoj;

import java.util.Scanner;

//RMQSQ range minimum query
public class RMQSQ {
    public static int table[][];
    public static void sparseTable(int array[]){
        int maxk, n = array.length;
        maxk = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
        table = new int[maxk+1][n];
        for(int i=0;i<n;i++) table[0][i] = array[i];

        for(int k = 1;k<=maxk;k++){
            for(int j=0;j+(1<<k)<=n;j++){
                table[k][j] = Math.min(table[k-1][j],table[k-1][j+(1<<(k-1))]);
            }
        }
    }
    public static int querymin(int a, int b){
        int ln = b-a+1;
        int k = Integer.numberOfTrailingZeros(Integer.highestOneBit(ln));
        int m = b-(1<<k)+1;
        return Math.min(table[k][a],table[k][m]);
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int array[];
        int n,Q,a,b;
        while(in.hasNext()){
            n = in.nextInt();
            array = new int[n];
            for(int i=0;i<n;i++){
                array[i] = in.nextInt();
            }
            sparseTable(array);
            Q = in.nextInt();
            while(Q-->0){
                a = in.nextInt();
                b = in.nextInt();
                System.out.println(querymin(a,b));
            }
        }
    }
}
