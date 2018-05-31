package hackerrank;

import java.util.*;

public class ComponestMaxmin {

    //3237 hackerrank
    private static int id[];
    private static int[]size;
    private static Map<Integer,Integer> weightU = new HashMap<>();
    public static void makesets(int n){
         id= new int[n];
         size = new int[n];
         for(int i=1;i<n;i++){
             id[i]=i;
             size[i]=1;
             weightU.put(i,1);
         }
    }
    public static int find(int p){
        while(p!=id[p]){
            id[p]=id[id[p]];
            p = id[p];
        }
        return p;
    }

    public static void unionfy(int p, int q){
        int root1 = find(p);
        int root2 = find(q);
        if(root1 == root2) return;
        if(size[root1]>size[root2]){
            id[root2]=root1;
            size[root1]+=size[root2];
            weightU.put(root1, size[root1]);
            weightU.remove(root2);
        }else{
            id[root1]=root2;
            size[root2]+=size[root1];
            weightU.put(root2, size[root2]);
            weightU.remove(root1);
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max=1,min=30001;
        makesets((n<<1)+1);
        while(n-->0){
            unionfy(in.nextInt(), in.nextInt());
        }
        for(Map.Entry<Integer,Integer> entry : weightU.entrySet()){
            if(entry.getValue()>1){
                max = Math.max(max,entry.getValue());
                min = Math.min(min,entry.getValue());
            }
        }

    }
}
