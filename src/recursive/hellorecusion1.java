package recursive;

/**
 * Created by parcpaes on 13/04/2018.
 */
public class hellorecusion1 {
    public static int hello(int count){
        if(count == 0) return 0;
        hello(count-1);
        System.out.println("Hello world "+count);
        return count;
    }

    public static void main(String arg[]){
        System.out.println(hello(10));
    }
}
