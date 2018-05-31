package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by parcpaes on 29/04/2018.
 */
public class SearchInsertPosition {
    public static int searchInsert(int nums[], int target){
        int mid, left=0, right=nums.length-1,index=0;
        while(left<=right){
            mid = (left+right)>>1;
            if(target < nums[mid]){
                right = mid-1;
                index = left;
            }else if(target > nums[mid]){
                left = mid+1;
                index = right;
            }else{
                return mid;
            }
        }
        return (index == -1)? 0: index;
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int array [] = new int[n];
            for(int i=0;i<n;i++){
                array[i] = in.nextInt();
            }
            int target = in.nextInt();
            System.out.println(searchInsert(array,target));
        }
    }
}
