package trees;

public class SpareTable {
    interface QueryInterface{
        public int minimum(int i, int j);
    }
    class SparseTable implements QueryInterface{
        int maxk , n;
        int [][] table;
        public SparseTable(int arr[]){
            n = arr.length;
            maxk = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
            table = new int[maxk][n];
            for(int i=0;i<n; i++)
                table[0][i] = arr[i];

            for(int k=1;k<=maxk;k++){
                for (int j = 0; j + (1<<k)<= n; j++) {
                    table[k][j] = Math.min(table[k-1][j], table[k - 1][j+(1<<(k-1))]);
                }
            }
        }
        @Override
        public int minimum(int a,int b){
            int len = (b-a+1);
            int k = Integer.numberOfTrailingZeros(Integer.highestOneBit(len));
            int m = b - (1<<k) + 1;
            return Math.min(table[k][a], table[k][m]);
        }
    }
}
