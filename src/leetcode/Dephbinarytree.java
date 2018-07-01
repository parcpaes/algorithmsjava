package leetcode;

public class Dephbinarytree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int i = maxDepth(root.left) + 1;
        int j = maxDepth(root.right) + 1;
        return Math.max(i,j);
    }
    public static void main(String arg[]){
        Dephbinarytree t = new Dephbinarytree();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        TreeNode right3 = new TreeNode(23);

        root.left = left;
        root.right = right;

        right.left=left2;
        right.right=right2;

        left2.left = right3;
        right3.right=new TreeNode(44);

        System.out.println(t.maxDepth(root));
    }
}
