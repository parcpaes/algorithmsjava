package trees;


import java.util.*;

public class CollectionTree {
    public static void main(String arg[]){
        TreeSet<String> al = new TreeSet<>();
        al.add("a");
        al.add("z");
        al.add("m");
        al.add("y");
        al.add("t");
        al.add("b");
        al.add("o");
        Iterator<String> itr = al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}