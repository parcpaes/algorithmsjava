package hackerrank;

import java.util.Arrays;

/**
 * Created by parcpaes on 10/04/2018.
 */
public class BinnarySearch {
    static int binaryfor(int array[], int value){
        int mid=0, left=0, right = array.length-1;
        while(left<=right){
            mid = (left + right)>>1;

            if(value < array[mid]){
                right = mid - 1;
            }else if(value > array[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return mid;
    }
    public static void main(String arg[]){
        int array[] = {1,2,4,5,13,20,25,40};
        System.out.println(binaryfor(array, 40));
        //Arrays.binarySearch()
    }
}
