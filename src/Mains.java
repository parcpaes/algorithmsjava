
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Mains {
    /*public static int id[];
    public static int sz[];
    public static int components;

    public static void makset(int n){
        components = n;
        id= new int[n];
        sz= new int[n];
        for(int i= 0;i<n;i++){
            id[i]=i;
            sz[i]=1;
        }
    }
    public static int find(int p){
        while(p!=id[p]){
            id[p]= id[id[p]];
            p= id[p];
        }
        return p;
    }
    public static void union(int p, int q){
        int root = find(p);
        int root2 = find(q);
        if(root==root2) return;
        if(sz[root]>sz[root2]){
            id[root2]=root;
            sz[root]+=sz[root2];
        }else{
            id[root]=root2;
            sz[root2]+=sz[root];
        }
        components = components-1;
    }
    public static void main(String arg[])throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String node;
        reader.readLine();
        while(n-->0){
            makset(reader.readLine().charAt(0)- 'A'+1);
            while((node = reader.readLine())!=null && !node.isEmpty()) {
                union(node.charAt(0) - 'A', node.charAt(1) - 'A');
            }
            System.out.println(components);
            if(n>0) System.out.println();
        }
    }*/
}
