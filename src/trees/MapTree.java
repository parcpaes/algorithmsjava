package trees;

/**
 * Created by parcpaes on 15/03/2018.
 */
import java.util.*;

public class MapTree {
    public static void main(String arg[]){
        Map<Character, Integer> tree = new TreeMap<>();
        tree.put('z',5);
        tree.put('m',8);
        tree.put('p',1);
        tree.put('k',2);
        tree.put('k',0);
        for(Map.Entry<Character,Integer> entry :  tree.entrySet()){
            System.out.println(entry.getKey()+" : " + entry.getValue());
        }
    }
}
