package recursive;

import java.util.*;

/**
 * Created by parcpaes on 12/04/2018.
 */
public class Hellorecursive{
    public static int  sum(int array[], int i){
        if(i == 0) return  array[i];
        int suma = sum(array,i-1);
        suma += array[i];
        System.out.printf("%d %d %d\n",i, suma, array[i]);
        int rest = Math.max(array[i], suma);
        return rest;
    }

    public static void main(String arg[]){
        int array[] = {-15,8,-2,1,0,6,-3};
        int maxlength,maxt;
        maxlength=maxt=array[0];
        for(int i=1;i<array.length;i++){
            maxlength = Math.max(array[i],maxlength+array[i]);
            maxt = (maxlength>maxt)? maxlength: maxt;
        }
        System.out.println(maxt);
        /*for(int i=0;i<array.length;i++){
            maxnum = Math.max(maxnum, sum(array,3));
        }
        System.out.println(maxnum);*/
    }

}
