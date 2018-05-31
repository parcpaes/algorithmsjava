package trees;


import java.util.Arrays;

public class SegmentTree {
    public static int array[];
    public static int tree[];
    public static int postLeft(int node){ return (node<<1)+1; }
    public static int postRight(int node){ return (node<<1)+2; }

    public static void makerange(int node, int left, int right){
        if(left == right){
            tree[node] = array[left];
            return;
        }else {
            int mid = (right + left)>>1;

            makerange(postLeft(node), left,  mid);
            makerange(postRight(node),mid+1,right);

            tree[node] = tree[postLeft(node)] + tree[postRight(node)];
        }
    }
    public static void update(int node, int left, int right, int index,int  value){
        if(left == right){
            tree[node] = value;
        }else{
            int mid = (right + left)>>1;
            if(index<= mid) update(postLeft(node), left, mid, index, value);
            else  update(postRight(node), mid+1, right, index, value);

            tree[node] = Math.min(tree[postLeft(node)], tree[postRight(node)]);
        }
    }
    public static void update(int index,int value){

    }
    public static int query(int node, int left, int right, int i, int j){
        if( i > right || j < left) return Integer.MAX_VALUE;
        if( i<= left && right <= j) return tree[node];
        int mid = (right + left)>>1;
        int p = query(postLeft(node),left, mid, i,j);
        int q = query(postRight(node),mid+1, right, i, j);

        return Math.min(p,q);
    }
    public static int query(int i, int j){
        return query(0, 0,array.length-1, i-1, j-1);
    }

    public static void makerangeBinary(){
        tree = new int[array.length*4];
        makerange(0,0,array.length-1);
    }

    public static void main(String arg[]){
        array = new int[]{8, 6, 2, 1, 0, 8};
        makerangeBinary();
        System.out.println();
    }
}
