package recursive;

/**
 * Created by parcpaes on 11/04/2018.
 */
public class factorial {
    public static int fact(int n, int j){
        if(n == 0){
            return 1;
        }else{
            int x = j + 2;
            int result =  n * fact(n-1, x);
            System.out.println(n +"  "+result);
            return result;
        }
    }
    public static void main(String arg[]){
        int n = 4;
        System.out.println("fact "+fact(n,0));
    }
}
