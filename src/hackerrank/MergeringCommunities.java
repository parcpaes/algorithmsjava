package hackerrank;

import java.util.Scanner;

/**
 * 4157 disjoin .
 */
public class MergeringCommunities {
    public static int id[];
    public static int size[];
    public static void makeset(int n) {
        id = new int[n];
        size = new int[n];
        for(int i=1;i<n;i++){
            id[i]= i;
            size[i]=1;
        }
    }

    public static int find(int p){
        while(p!=id[p]){
            id[p]= id[id[p]];
            p = id[p];
        }
        return p;
    }
    public static void union(int p, int q){
        int root1 = find(p);
        int root2 = find(q);
        if(root1 == root2) return;
        if(size[root1]>size[root2]){
            id[root2]= root1;
            size[root1]+=size[root2];
        }else{
            id[root1]= root2;
            size[root2]+=size[root1];
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int q = Integer.parseInt(in.next());
        int x,y;
        String m;
        makeset(n+1);
        while(q-->0){
            m = in.next();
            if(m.equals("M")){
                x = Integer.parseInt(in.next());
                if(n>1){
                    y = Integer.parseInt(in.next());
                    union(x,y);
                }
            }else{
                x = Integer.parseInt(in.next());
                System.out.println(size[find(x)]);
            }
        }
    }
}
