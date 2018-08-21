package trees;

public class LcaBinaryTree {
    public static class TreeNode implements Comparable<TreeNode>{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x){
            this.val = x;
        }

        @Override
        public int compareTo(TreeNode o) {
            if(this.val < o.val) return -1;
            if(this.val > o.val) return 1;
            return 0;
        }
    }
    public TreeNode lca(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) return null;

        if((root.compareTo(A) == 0)  || (root.compareTo(B) == 0)) return root;

        TreeNode left = lca(root.left, A, B);
        TreeNode right = lca(root.right, A, B);
        if(left != null && right != null) return root;
        else if(left == null && right == null) return null;
        return (left !=null) ? left: right;
    }
    public static void main(String argp[]){
        LcaBinaryTree lca = new LcaBinaryTree();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        TreeNode left3 = new TreeNode(23);

        root.left = left;
        root.right = right;

        left.right = new TreeNode(5);

        right.left=left2;
        right.right=right2;

        left2.left = left3;
        left2.right=new TreeNode(44);
        left3.right = new TreeNode(60);

        System.out.println(lca.lca(root, new TreeNode(60), new TreeNode(20)).val);
    }
}
