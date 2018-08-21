package trees;

public class BinaryTree {
    public static void main(String arg[]){
        BTS<Character,Integer> tree = new BTS<>();
        tree.put('S',1);
        tree.put('E',2);
        tree.put('X',3);
        tree.put('A',4);
        tree.put('C',5);
        tree.put('R',6);
        tree.put('H',7);
        tree.put('M',8);
        tree.put('A',9);

        System.out.println(tree.select(0));
        System.out.println(tree.select(6));
    }
}
