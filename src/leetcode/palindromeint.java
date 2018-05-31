package leetcode;

/**
 * Created by parcpaes on 13/04/2018.
 */
public class palindromeint {
    public static boolean isPalindrome(int x) {
        int div=x,suma=0;
        if(x<0 && x!=0) return false;
        while(div>0){
            suma = suma * 10 +  div%10;
            div=div/10;
        }
        return (x == suma);
    }
    public static void main(String arg[]){
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
