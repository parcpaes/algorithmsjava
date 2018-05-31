package coj;

import java.util.Scanner;

/**
 * Created by parcpaes on 09/09/2017.
 *  2637
 */
public class SumaIntervalo {
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
            tree[node] = tree[leftPost(node)]+tree[rightPost(node)];
        }
    }
    public static long query(int node, int left, int right, int i, int j){
        if(i > right || j < left) return 0;
        if(i<= left && right<= j) return  tree[node];
        int mid = (left + right)>>1;
        long sumA = query(leftPost(node), left, mid,i,j);
        long sumB = query(rightPost(node), mid+1, right,i,j);
        return sumA + sumB;
    }
    public static long query(int i, int j){
        return query(0,0,data.length-1,i,j);
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m,q;
        while(n-->0){
            m = in.nextInt();
            q = in.nextInt();
            data = new int[m];
            tree = new long[(m<<2)];
            for (int i=0 ; i< m ; i++){
                data[i] = in.nextInt();
            }
            init(0,0,data.length-1);
            while (q-->0){
                int begin = in.nextInt();
                int end = in.nextInt();
                System.out.println(query(begin,end));
            }
            if(n>0) System.out.println();
        }
    }
}
