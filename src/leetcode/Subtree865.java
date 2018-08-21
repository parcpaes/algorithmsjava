package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subtree865 {
    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){
            val = x;
        }
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        int i= depth(root.left) +1;
        int j= depth(root.right) +1;
        return Math.max(i,j);
    }
    public void depthSub(TreeNode root, int h,LinkedList<TreeNode> paths, List<List<TreeNode>> list){
        if(root == null) return;
        paths.add(root);
        if((root.left != null || root.right != null) && h-1==1) list.add(new ArrayList<>(paths));
        depthSub(root.left,h-1,paths,list);
        depthSub(root.right,h-1,paths,list);
        paths.removeLast();
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root){
        if(root.left == null && root.right == null) return root;
        LinkedList<TreeNode> paths = new LinkedList<>();
        List<List<TreeNode>> list = new ArrayList<>();
        depthSub(root,depth(root), paths,list);
        List<TreeNode> node1 = list.get(0);
        TreeNode nodeDep = node1.get(node1.size()-1);
        if(list.size()>1){
            List<TreeNode> node2 = list.get(list.size()-1);
            for(int i=1;i<node1.size();i++){
                if(node1.get(i).val != node2.get(i).val) return node1.get(i-1);
            }
        }
        if(nodeDep.left !=null && nodeDep.right !=null) return nodeDep;
        else return nodeDep.left!=null ? nodeDep.left: nodeDep.right;
    }
    public static void main(String arg[]){
        Subtree865 sub = new Subtree865();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(8);

        TreeNode left11 = new TreeNode(3);
        TreeNode left2 = new TreeNode(6);
        left2.left = new TreeNode(20);
        left2.right = new TreeNode(11);
        left11.left =  left2;

        TreeNode right1 = new TreeNode(2);
        TreeNode left2r = new TreeNode(5);
        left2r.left = new TreeNode(12);
        left2r.right = new TreeNode(15);
        right1.left = left2r;
        
        TreeNode right2r = new TreeNode(4);
        right2r.left = new TreeNode(17);
        right2r.right = new TreeNode(9);

        right1.right = right2r;

        TreeNode r = new TreeNode(12);
        TreeNode r2 = new TreeNode(14);

        root.left = left;
        root.right = right;
        right.right = r;


        r.right= r2;
        r2.right = new TreeNode(50);


        left.left = left11;
        left.right = right1;



        System.out.println(sub.subtreeWithAllDeepest(root).val);
    }
}
