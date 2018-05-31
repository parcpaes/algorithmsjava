package leetcode;

/**
 * Created by parcpaes on 08/05/2018.
 */
public class reverse3 {
    public static String reverseWords(String s){
        char letter[] = s.toCharArray();
        String result = "";
        String r = "";
        for(int i=0;i<letter.length;i++){
             if(letter[i]== ' '){
                result+=r+letter[i];
                r="";
             }else{
                 r = letter[i]+r;
             }
        }
        result+=r;
        return result;
    }

    public static void main(String arg[]){
        System.out.println(reverseWords("Let's take LeetCode contest marca"));
    }
}
