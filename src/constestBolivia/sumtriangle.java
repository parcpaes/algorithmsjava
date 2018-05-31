package constestBolivia;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by parcpaes on 02/11/2017.
 */
public class sumtriangle {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nl,cont, aux, sum;
        while(n-->0){
            nl = in.nextInt();
            int array[] = new int[nl+1];
            aux = 1;
            sum  = cont= 0;
            while(cont< nl){
                cont++;
                for(int i = 0; i<cont;i++){
                    array[i] = in.nextInt();
                }
                Arrays.sort(array,0,aux);
                sum += array[aux-1];
                aux = cont;
            }
            System.out.printf("%d\n", sum);
        }
    }
}
