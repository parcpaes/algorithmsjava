package leetcode;

/**
 * Created by parcpaes on 29/04/2018.
 */
public class JewelsStones {
    static int numJewelsInStones(String J, String S){
        String resul = S.replaceAll("[^"+J+"]","");
        return resul.length();
    }
    public static void main(String arg[]){
        System.out.println(numJewelsInStones("aA","aAAbbAbbaA"));
    }
}
