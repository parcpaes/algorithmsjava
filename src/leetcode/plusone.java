package leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.*;

public class plusone {
    public static int[] plusOne(int digits[]){
        String nums = Arrays.toString(digits).replaceAll("[^\\d]","");
        BigInteger sum = new BigInteger(nums);
        sum = sum.add(new BigInteger("1"));
        nums = sum.toString();
        int  array[] = new int[sum.toString().length()];
        for(int i=0;i<array.length;i++){
            array[i] = Integer.parseInt(""+nums.charAt(i));
        }
        return array;
    }
    public static void main(String arg[]){
        int array[] = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(array)));
    }
}
