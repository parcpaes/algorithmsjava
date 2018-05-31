package trees;

public class BTS<Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }
    public Value get(Key key){
        Node x = root;
        while(x!=null){
            int comp = key.compareTo(x.key);
            if(comp < 0) x = x.left;
            else if(comp > 0)  x = x.right;
            else return x.val;
        }
        return null;
    }
}
