package coj;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by parcpaes on 07/05/2018.
 * 2196
 */
public class evenoodd {
    public static void main(String arg[]){
        Scanner in =new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        while(n-->0){
            String value = in.next();
            int number = Integer.parseInt(""+value.charAt(value.length()-1));
            if((number&1)==0) System.out.println("even");
            else System.out.println("odd");
        }
    }
}
