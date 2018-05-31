package uva;

import java.util.Scanner;

/**
 * Created by parcpaes on 12/09/2017.
 * 10298
 */
public class powerString {
    public static int preprocesKmp(char pattern[]){
        int n = pattern.length;
        int lsp[]= new int[pattern.length];
        int i=1, index=0;
        while (i<n){
            if(pattern[i] == pattern[index]){
                lsp[i]= index+1;
                index ++;
                i++;
            }else{
                if(index !=0){
                    index = lsp[index-1];
                }else {
                    lsp[i] = 0;
                    i++;
                }
            }
        }
        return (n/(n-lsp[n-1]));
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int max = 1;
        while(true){
            String cad = in.next();
            if(cad.equals(".")) break;
            System.out.println(preprocesKmp(cad.toCharArray()));
        }
    }
}
