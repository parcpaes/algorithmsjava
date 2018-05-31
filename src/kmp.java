/**
 * Created by parcpaes on 11/09/2017.
 */
public class kmp {
    /*public static int[] kmpPrepoces(char pattern[]){
        int lps[]= new int[pattern.length];
        lps[0]=0;
        int index = 0, i=1;
        while(i< pattern.length){
            if(pattern[index] == pattern[i]){
                lps[i]=index+1;
                index++;
                i++;
            }else{
                if(index!=0){
                    index =  lps[index-1];
                }else {
                    lps[i]= 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static boolean searchKmp(char []text, char []pattern){
        int []lsp = kmpPrepoces(pattern);
        int i=0,j=0;
        while(i<text.length && j< pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lsp[j-1];
                }else{
                    i++;
                }
            }
        }

        return j == pattern.length;
    }
    public static void main(String arg[]){
        String str =  "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        boolean result = searchKmp(str.toCharArray(), subString.toCharArray());
        System.out.println(result);
    }*/
}
