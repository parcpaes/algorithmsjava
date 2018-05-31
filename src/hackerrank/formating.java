package hackerrank;
import java.util.Scanner;
/**
 * Created by parcpaes on 22/08/2017.
 */
public class formating {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            int space = -((15 - s1.length())+s1.length());
            String format = "%"+space+"s%03d\n";
            System.out.printf(format,s1,x);
        }
        System.out.println("================================");
    }
}
