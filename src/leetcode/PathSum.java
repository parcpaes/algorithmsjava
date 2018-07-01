package leetcode;

public class PathSum {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean sumpath(TreeNode root, int sum, int result){
        if(root == null) return false;
        if(root.left==null && root.right == null){
            if(sum == (result+root.val)) return true;
        }
        return sumpath(root.left,sum,result+root.val) || sumpath(root.right,sum,result+root.val);
    }
    public boolean hasPathSum(TreeNode root,int sum){
        return sumpath(root,sum,0);
    }

    public boolean secondHasPath(TreeNode root, int sum){
        if(root == null) return false;
        if(root.left ==null && root.right == null && (sum-root.val)==0) return true;
        return secondHasPath(root.left, sum-root.val) || secondHasPath(root.right, sum-root.val);
    }

    public static void main(String arg[]){
        PathSum p = new PathSum();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);

        TreeNode left11 = new TreeNode(11);

        TreeNode left2 = new TreeNode(13);
        TreeNode right2 = new TreeNode(4);

        TreeNode right3 = new TreeNode(23);

        root.left = left;
        root.right = right;

        left.right = left11;
        left11.left = new TreeNode(7);
        left11.right = new TreeNode(2);

        right.left=left2;
        right.right=right2;

        right2.right = new TreeNode(1);
        System.out.println(p.hasPathSum(root,22));
    }
}
