package hackerrank;
import java.util.Scanner;

public class StringIntro {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length()+B.length());

        System.out.println((A.compareTo(B)>0)?"Yes":"No");
        A = A.substring(0,1).toUpperCase()+A.substring(1,A.length());
        B = B.substring(0,1).toUpperCase()+B.substring(1,B.length());
        System.out.println(A+" "+B);
    }
}
