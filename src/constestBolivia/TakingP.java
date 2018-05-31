package constestBolivia;

import java.util.Scanner;

/**
 * Created by parcpaes on 03/09/2017.
 */
public class TakingP {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            String cad[] = in.nextLine().split("\\s+");
            String result="";
            for (int i=0; i< cad.length;i++){
                result = result + cad[i].replaceAll("([aeiou])","$1p$1")+" ";
            }
            System.out.println(result);
        }
    }
}
