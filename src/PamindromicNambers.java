
import java.util.ArrayList;;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parcpaes on 04/10/2017.
 */
public class PamindromicNambers {
    public List<Long> tree[];
    public long data[];
    public int getLeft(int node){return node<<1+1;}
    public int getRight(int node){return node<<1+2;}


    public void init(int node,int left, int right){
        if(left == right){
            tree[node] = new ArrayList<>();
            tree[node].add(data[left]);
        }else{
            int mid = (left + right)>>1;
            init(getLeft(node), left, mid);
            init(getRight(node), mid+1, left);
            tree[node] = tree[getLeft(node)];
        }
    }
    public static void main(String arg[]){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(3);
        list1.add(6);
        list1.add(3);

        list2.add(3);
        list2.add(6);
        list2.add(3);
        System.out.println(Arrays.equals(list1.toArray(),list2.toArray()));

    }
}
