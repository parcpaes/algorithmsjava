package hackerrank;

import java.util.Scanner;

/**
 * Created by parcpaes on 22/08/2017.
 */
public class Endfile {
    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        int n=1;
        while(scanner.hasNextLine()){
            String msg = scanner.nextLine();
            System.out.printf("%d %s\n",n,msg);
            n++;
        }

    }
}
