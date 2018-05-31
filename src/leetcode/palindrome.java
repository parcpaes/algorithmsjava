package leetcode;

/**
 * Created by parcpaes on 13/04/2018.
 */
public class palindrome {
    public static int reverse(int x) {
        long sign = 1, div= Math.abs(x),suma=0;
        //dig = (long)Math.log10(div)+1;
        if(x<-Integer.MAX_VALUE) return 0;
        //if(dig<=1) return x;
        //sign = ((x/div)==-1)? -1: 1;
        while(div>0){
            suma = suma * 10 +  div%10;
            if(suma>Integer.MAX_VALUE){
                suma = 0;
                break;
            }
            div=div/10;
            //suma += mod*(long)Math.pow(10,dig)/10;


            //dig--;
        }
        return (int) (suma*sign);
    }
    public static void main(String arg[]){
        int x = 2147;
        System.out.println(reverse(x));
    }
}
