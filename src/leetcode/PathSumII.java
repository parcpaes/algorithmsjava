package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class PathSumII {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public void paths(TreeNode root, int sum, LinkedList<Integer> paths, List<List<Integer>> list){
        if(root == null) return;
        paths.add(root.val);
        if(root.left == null && root.right == null && (sum - root.val) == 0) list.add(new ArrayList<>(paths));
        paths(root.left, sum - root.val, paths,list);
        paths(root.right, sum - root.val, paths,list);
        paths.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        LinkedList<Integer> paths = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.size();
        paths(root, sum, paths,list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        return list;
    }
    public static void main(String arg[]){
        PathSumII p2 = new PathSumII();

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);

        TreeNode left11 = new TreeNode(11);

        TreeNode left2 = new TreeNode(13);
        TreeNode right2 = new TreeNode(4);

        //TreeNode right3 = new TreeNode(23);

        root.left = left;
        root.right = right;

        left.right = left11;
        left11.left = new TreeNode(7);
        left11.right = new TreeNode(2);

        right.left=left2;
        right.right=right2;

        right2.left = new TreeNode(5);
        right2.right = new TreeNode(1);
        p2.pathSum(root, 22);
    }
}
