import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// union find
// disjoinset
public class VirutalFriend {

    private static int id[] = new int[100005];
    private static int sz[] = new int[100005];

    public static void makeSet(int n){
        for(int i=0;i<n;i++){
            id[i]=i;sz[i]=1;
        }
    }
    public static int find(int p){
        while(p!=id[p]){
            id[p]= id[id[p]];
            p= id[p];
        }
        return p;
    }
    public static int  union(int p, int q){
        int root1= find(p);
        int root2= find(q);
        if(root1==root2) return  sz[root1];

        if(sz[root1]>sz[root2]){
            id[root2]= root1;
            sz[root1]+=sz[root2];
            return sz[root1];
        }else{
            id[root1]= root2;
            sz[root2]+=sz[root1];
            return sz[root2];
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        String friend1;
        String friend2;
        Map<String,Integer> mapFriends = new HashMap<>();
        int n = in.nextInt();
        int cont = 0;
        while (n-- > 0) {
            int f = in.nextInt();
            makeSet(Math.min(f<<1, 100001));
            while(f-->0){
                friend1=in.next();
                friend2=in.next();
                Integer valueA = mapFriends.get(friend1);
                Integer valueB = mapFriends.get(friend2);
                if(valueA==null){
                    mapFriends.put(friend1,++cont);
                    valueA=cont;
                }
                if(valueB==null){
                    mapFriends.put(friend2,++cont);
                    valueB=cont;
                }
                System.out.println(union(valueA,valueB));
            }
        }
    }
}
