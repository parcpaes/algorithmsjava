package coj;

import java.util.Scanner;

/**
 * Created by parcpaes on 18/09/2017.
 * 2250
 */
public class SubStringFrecuence {
    public static int[] kmpPreprocess(char []pattern){
        int []dsp=new int[pattern.length];
        dsp[0]=0;
        int index=0, i = 1;
        while(i< pattern.length){
            if(pattern[i] == pattern[index]){
                dsp[i]=index+1;
                index++;
                i++;
            }else{
                if(index!=0){
                    index = dsp[index-1];
                }else{
                    dsp[i] = 0;
                    i++;
                }
            }
        }
        return dsp;
    }
    public static int searchkmp(char text[], char pattern[]){
        int []lsp = kmpPreprocess(pattern);
        int i=0, j=0, cont=0;
        while (i<text.length && j < pattern.length){
            if(pattern[j]==text[i]){
                i++; j++;
            }else{
                if(j!= 0){
                    j= lsp[j-1];
                }else{
                    i++;
                }
            }
            if(j == pattern.length){
                j = lsp[j-1];
                cont++;
            }
        }
        return cont;
    }
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int t=Integer.parseInt(in.next());
        int i=1;
        while(t-->0){
            String text = in.next();
            String pattern = in.next();
            System.out.printf("Case %d: %d\n",i++,searchkmp(text.toCharArray(), pattern.toCharArray()));
        }
    }
}
