package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by parcpaes on 09/05/2018.
 */
public class reversevowel {
    private static TreeSet<Character> vowels = new TreeSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public static String reverseVowels(String s){
        char letter[] = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        boolean vow1,vow2;
        while(i<j){
            char temp1 = letter[i];
            vow1 = vowels.contains(temp1);
            vow2 = vowels.contains(letter[j]);
            if(vow1 && vow2){
                letter[i++]=letter[j];
                letter[j--] = temp1;
            }
            if(!vow1)i++;
            if(!vow2)j--;
        }
        return String.valueOf(letter);
    }
    public static void main(String arg[]){
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("helly"));
        System.out.println(reverseVowels("akekioku"));

    }
}
