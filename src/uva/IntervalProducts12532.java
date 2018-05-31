package uva;

// uva interval products 12532

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntervalProducts12532 {
    public static int tree[];
    public static int data[];
    public static int getLeft(int node){ return (node<<1)+1;}
    public static int getRight(int node){ return (node<<1)+2;}

    public static int merge(int valueA, int valueB){
        int result = valueA * valueB;
        if(result==0) return 0;
        if(result < 0) return -1;
        return 1;
    }
    public static void init(int node , int left, int right){
        if( left == right){
            tree[node]= data[left];
        }else{
            int mid = (left+right)>>1;
            init(getLeft(node), left,mid);
            init(getRight(node), mid+1,right);

            tree[node]= merge(tree[getLeft(node)], tree[getRight(node)]);
        }
    }
    public static void updateTree(int node,int left, int right, int index, int value){
        if(left == right){
            tree[node]= value;
        }else {
            int mid = (left+ right)>>1;
            if(index <= mid)updateTree(getLeft(node), left, mid,index, value);
            else updateTree(getRight(node), mid+1, right,index,value);

            tree[node] = merge(tree[getLeft(node)], tree[getRight(node)]);
        }
    }
    public static void updateTree(int index ,int value){
        updateTree(0,0, data.length-1,index-1, value);
    }
    public static int query(int node, int left, int right, int i, int j){
        if(i>right || j < left) return 1;
        if(i<=left && right<=j) return tree[node];
        int mid = (left + right)>>1;
        int p = query(getLeft(node), left, mid, i , j);
        int q = query(getRight(node), mid+1,right,i, j);
        return p*q;
    }
    public static int query(int i,int j){
        return query(0,0,data.length-1,i-1,j-1);
    }

    public static void main(String arg[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n,k, index, value;
        String line=null;
        StringTokenizer token;

        while (true){
            line = reader.readLine();
            if(line.isEmpty()) break;
            token = new StringTokenizer(line);
            n = Integer.parseInt(token.nextToken());
            k = Integer.parseInt(token.nextToken());
            data = new int[n];
            token = new StringTokenizer(reader.readLine());
            for(int i=0; i<n; i++){
                data[i]= Integer.parseInt(token.nextToken());
            }
            tree = new int[n<<2];
            //Arrays.fill(tree,1);
            init(0,0,data.length-1);

            while(k-->0){
                token = new StringTokenizer(reader.readLine());
                String command = token.nextToken();
                if(command.equals("C")){
                    index = Integer.parseInt(token.nextToken());
                    value = Integer.parseInt(token.nextToken());
                    updateTree(index, value);
                }else{
                    int result = query(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()));
                    if(result==0) System.out.printf("%d",0);
                    else if(result<0) System.out.printf("%s","-");
                    else System.out.printf("%s","+");
                }
            }

        }
    }
}
