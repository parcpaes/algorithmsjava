package hackerrank;

/**
 * Created by parcpaes on 22/08/2017.
 */
public class StaticClass {
    static int i;
    int j;

    static{
        i=10;
        System.out.printf("Static block called \n");
    }
    {
        System.out.printf("Non-static block\n");
    }
    StaticClass(){
        System.out.printf("Constructor Called\n");
    }
}
