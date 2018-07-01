package leetcode;

public class Mindepthtree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public int minDepth(TreeNode root){
        if(root == null) return 0;

        int x = minDepth(root.left);
        int y = minDepth(root.right);

        if(x == 0 || y == 0) return x+y+1;
        else return Math.min(x,y)+1;
    }
    public static void main(String arg[]){
        Mindepthtree t = new Mindepthtree();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        TreeNode right3 = new TreeNode(23);

        root.left = left;
        root.right = right;

        left.right = new TreeNode(5);

        right.left=left2;
        right.right=right2;

        left2.left = right3;
        right3.right=new TreeNode(44);

        System.out.println(t.minDepth(root));
    }
}
