package coj;

/**
 * Created by parcpaes on 02/11/2017.
 */
import java.util.Scanner;
public class minrange {
    public static long tree[];
    public static int data[];
    public static int leftPost(int node){return (node<<1)+1;}
    public static int rightPost(int node){ return (node<<1)+2;}
    public static void init(int node, int left, int right){
        if(left == right) {
            tree[node] = data[left];
        }else{
            int mid = (left+right)>>1;
            init(leftPost(node), left , mid);
            init(rightPost(node), mid+1,right);
            tree[node] = Math.min(tree[leftPost(node)], tree[rightPost(node)]);
        }
    }
    public static long query(int node, int left, int right, int i, int j){
        if(i > right || j < left) return Integer.MAX_VALUE;
        if(i<= left && right<= j) return  tree[node];
        int mid = (left + right)>>1;
        long sumA = query(leftPost(node), left, mid,i,j);
        long sumB = query(rightPost(node), mid+1, right,i,j);
        return Math.min(sumA, sumB);
    }
    public static long query(int i, int j){
        return query(0,0,data.length-1,i-1,j-1);
    }

    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tree = new long[(n << 2) + 1];
        data = new int[n];
        for(int i=0; i< n; i++){
            data[i] = in.nextInt();
        }
        init(0,0,n-1);
        int q = in.nextInt();
        while(q-->0){
            int st = in.nextInt();
            int ed = in.nextInt();
            System.out.printf("%d\n", query(st,ed));
        }
    }
}
