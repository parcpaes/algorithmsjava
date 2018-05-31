package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by parcpaes on 11/09/2017.
 * 455
 */
public class PeriodicString {

    public static int searchKmp(char text[],char pattern[]){
        int i=0,j=0, cont=0;
        while(i<text.length){
            while(i < text.length && j < pattern.length && text[i]==pattern[j]){ i++; j++; }
            if(j == pattern.length){
                cont = cont + j;
                j=0;
            }else{
                cont = -1;
                break;
            }
        }
        return cont;
    }
    public static void main(String arg[]) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        String text;

        while(n-->0){
            buffer.readLine();
            text = buffer.readLine();
            int min = Integer.MAX_VALUE;
            for (int i=1; i<= text.length();i++){
                String str = text.substring(0,i);
                if (searchKmp(text.toCharArray(),str.toCharArray())>0){
                    min = Math.min(min, str.length());
                }
            }
            System.out.println(min);
            if(n>0) System.out.println("");
        }
    }
}
