package coj;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by parcpaes on 02/11/2017.
 * 1658
 */
public class Longestincreasing {
    public static int longest(int array[]){
        int index[] = new int[array.length];
        Arrays.fill(index, 1);
        int max = 1;
        for(int i=1; i< array.length; i++){
            for(int j=0; j<i; j++){
                if(array[i]>array[j]){
                    if(index[j]+1>index[i]){
                        index[i] = array[j] +1;
                    }
                }
            }
            max = Math.max(index[i],max);
        }
        return max;
    }

    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int numbers = 0, array [];
        while(n-->0){
            numbers = in.nextInt();
            array = new int[numbers];
            System.out.println(n);
            for(int i = 0; i < numbers; i++){
                array[i] = in.nextInt();
            }
            System.out.printf("%d\n", longest(array));
        }
    }
}
