package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class twosum {
    public static int [] indexsum(int []numbers, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int index1, index2;
        for(int i=0;i<numbers.length; i++){
            int complement = target - numbers[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement)+1,i+1};
            }
            map.put(numbers[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String arg[]){
        int array[] = {0,0,3,4};
        Object arr[] = {0,0,3,4};
        System.out.println(Arrays.toString(indexsum(array,0)));
        IntStream.of(array).distinct().toArray();
    }
}
