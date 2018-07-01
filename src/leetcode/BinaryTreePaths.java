package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public LinkedList<String> nodes = new LinkedList<>();

    public void searchBT(TreeNode root, String path, List<String> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(path+""+root.val);
        }
        searchBT(root.left,path+root.val+"->",list);
        searchBT(root.right,path+root.val+"->",list);
    }

    public void treePaths(TreeNode root,List<String> list){
        if(root == null) return;
        nodes.add(""+root.val);
        if(root.left == null && root.right == null){
            String s = "";
            for(int i=1;i<nodes.size(); i++){
                 s += "->"+nodes.get(i);
            }
            list.add(nodes.get(0)+s);
        }
        treePaths(root.left,list);
        treePaths(root.right,list);
        nodes.removeLast();
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        //nodes.clear();
        searchBT(root,"",paths);
        return paths;
    }
    public static void main(String arg[]){
        BinaryTreePaths b = new BinaryTreePaths();
        StringBuffer cas = new StringBuffer();

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
        left2.right=new TreeNode(44);
        right3.right = new TreeNode(60);
        System.out.println(Arrays.toString(b.binaryTreePaths(root).toArray()));
    }
}


