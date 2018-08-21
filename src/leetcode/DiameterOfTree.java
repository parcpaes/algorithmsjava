package leetcode;

import java.util.Map;
//543
public class DiameterOfTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public static int max=0;
    public static int height(TreeNode root){
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1+Math.max(l,r);
    }
    public static int depthTree(TreeNode root){
        if(root == null) return 0;
        int i = depthTree(root.left)+1;
        int j = depthTree(root.right)+1;
        return Math.max(i,j);
    }
    public static int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        int a = depthTree(root.left)-1;
        int b = depthTree(root.right)-1;
        int x = diameterOfBinaryTree(root.left);
        int y = diameterOfBinaryTree(root.right);
        return Math.max((a+b)+2,Math.max(x,y));
    }
    public static int secondSolution(TreeNode root){
        max = 0;
        maxDepth(root);
        return max;
    }
    private static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left+right);
        return Math.max(left,right)+1;
    }

    public static void main(String arg[]){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        //left.left = new TreeNode(4);
        //left.right = new TreeNode(5);
        root.left =left;
        root.right = right;
        System.out.println(maxDepth(root));
    }
}
