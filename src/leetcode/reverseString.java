package leetcode;

import java.util.Arrays;

/**
 * Created by parcpaes on 07/05/2018.
 */
public class reverseString {
    public static String reverse(String s){
        char val[] = s.toCharArray();
        char reverse[] = new char[s.length()];
        int i=0, n = s.length();
        for(int j=n-1;i<j && j>i;i++,j--){
            reverse[i] = val[j];
            reverse[j] = val[i];
        }
        if((n&1)==1) reverse[i] = val[i];
        return String.valueOf(reverse);
    }
    public static String reverseStr(String s, int k){
        if(k>s.length()) return reverse(s);
        if((k<<1)>s.length() && k<=s.length()) return reverse(s.substring(0,k))+s.substring(k,s.length());
        StringBuffer resul = new StringBuffer(s);
        for(int i=0;i<s.length();i=i+(k<<1)){
            if((i+k)>=s.length()){
                resul.replace(i,k+i, reverse(s.substring(i,s.length())));
                break;
            }
            resul.replace(i,k+i, reverse(s.substring(i,i+k)));
        }
        return resul.toString();
    }
    public static void main(String arg[]){
        System.out.println(reverseStr("abcdefgm",3));
    }
}
