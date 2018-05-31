package coj;

import java.util.Scanner;

/**
 * Created by parcpaes on 02/11/2017.
 */
public class coins {
    public static int coins[] = {1,5,10,25,50};
    public static long temp[][] = new long[coins.length+1][7500];
    public static void waysgetTotal(int total){

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<= total; j++){
                if(coins[i-1] > j)  temp[i][j] = temp[i-1][j];
                else  temp[i][j]= temp[i][j-coins[i-1]] + temp[i-1][j];
            }
        }
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int total;
        for(int i=0;i<=coins.length; i++)temp[i][0] = 1;
        waysgetTotal(7499);
        while(in.hasNext()){
            total = Integer.parseInt(in.next());
            System.out.printf("%d\n", temp[coins.length][total]);
        }
    }
}
