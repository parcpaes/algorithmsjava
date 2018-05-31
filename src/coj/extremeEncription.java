package coj;

import java.util.Arrays;
import java.util.Scanner;

public class extremeEncription {
    public static int mat[][];
    public static int sequence(String cadA, String cadB){
        mat= new int[cadA.length()+1][cadB.length()+1];
        int choose2,choose3;
        for (int i = 1; i <= cadA.length(); i++) {
            for (int j = i; j <= cadB.length(); j++) {
                if(cadA.charAt(i-1) == cadB.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1] +1;
                }else{
                    choose2 = mat[i-1][j];
                    choose3 = mat[i][j-1];
                    mat[i][j] = Math.max(choose2, choose3);
                }
            }
        }
        return mat[cadA.length()][cadB.length()];
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNextLine()) {
            String cad = in.nextLine();
            String f[] = cad.split(" ");
            if(f[0].length() == sequence(f[0], f[1])) System.out.println("Yes");
            else  System.out.println("No");
        }
    }
}
