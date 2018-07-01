package leetcode;


import java.util.TreeSet;

public class FindDuplicateNumber {
    public static int findDuplicate(int nums[]){
        boolean visited[] = new boolean[nums.length+1];
        for(int i=0;i<nums.length-1;i++){
            if(visited[nums[i]]) return nums[i];
            visited[nums[i]] = true;
        }
        return nums[nums.length-1];
    }
    public static void main(String arg[]){
        int array[] = {9,11,6,5,1,3,4,2,10,1,7};
        System.out.println(findDuplicate(array));
    }
}
