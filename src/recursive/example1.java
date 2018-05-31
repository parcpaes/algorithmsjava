package recursive;

/**
 * Created by parcpaes on 15/03/2018.
 */
public class example1 {

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }else{
            int result = n* factorial(n-1);
            System.out.println(n);
            return result;
        }
    }
    public static void main(String arg[]){
        int f = factorial(4);
        System.out.println("result" +f);
    }
}
