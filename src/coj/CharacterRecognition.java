package coj;

import java.util.Scanner;

/**
 * Created by parcpaes on 09/09/2017.
 * 1807
 */
public class CharacterRecognition {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int car = 0;
        int sum =0;
        double resul;
        while(n-->0){
            car = sum =0;
            while(true){
                String cadena = in.nextLine();
                if (cadena.isEmpty()) break;
                String caracter = cadena.replaceAll("#","");
                car = car + caracter.length();
                sum = sum + cadena.length();
            }

            if((car*100)%sum==0){
                System.out.printf("Efficiency ratio is %d%%.\n",(int)((car/(double)sum)*100));
            }else{
                resul = car/(double)sum*100;
                resul = Math.round(resul*100.0)/100.0;
                double remain = resul - Math.floor(resul);
                if(remain<=0.044)System.out.printf("Efficiency ratio is %d%%.\n",(int)(resul));
                else System.out.printf("Efficiency ratio is %.1f%%.\n",resul);
            }
        }
    }
}
