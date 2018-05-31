package recursive;

/**
 * Created by parcpaes on 12/04/2018.
 */
public class fibonacci {

    static int fib(int n){
        if(n<=2){
            return 1;
        }else{
            int result = fib(n-2);
            int result2 = fib(n-1);
            return result + result2;
        }
    }

    public static void main(String arg[]){
        System.out.println(fib(6));
    }
}
