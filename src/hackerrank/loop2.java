package hackerrank;
import java.util.Scanner;

public class loop2 {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int result=a;
            String space="";
            for(int i=0;i<n;i++){
                result = result +(int)Math.pow(2,i) * b;
                System.out.print(space+result);
                space=" ";
            }
            System.out.println();
        }
        in.close();
    }
}
