package leetcode;

import java.util.*;

/**
 * Created by parcpaes on 29/04/2018.
 */
public class IntersectionArray {
    public static int[] intersection(int nums1[], int nums2[]){
        TreeSet<Integer> setjoin = new TreeSet<>();
        int index = 0;
        int j = 0;
        Arrays.sort(nums2);
        for(Integer num: nums1){
            index = Arrays.binarySearch(nums2, num);
            if(index>=0 && (num == nums2[index])){
                setjoin.add(num);
            }
        }
        int result [] = new int[setjoin.size()];
        for(Integer value : setjoin){
            result[j++] = value;
        }
        return result;
    }
    public static void main(String arg[]){
        int numbers1[] = {1,3,5,1,7,9};
        int numbers2[] = {3,1,0};
        System.out.println(Arrays.toString(intersection(numbers1,numbers2)));
    }
}
