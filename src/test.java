import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by parcpaes on 13/08/2017.
 */
public class test {
    public static void main(String arg[]){
        Map<String,Integer> map= new HashMap<>();
        System.out.println(map.get("hola")==null);
        System.out.println(2<<1);
        System.out.println('B'-'A');
        System.out.println(-5460>>1);
        int n =-100;
        String s = Integer.toString(n);
        System.out.println(s.equals(""+n));
        System.out.println(Math.pow(4,2));
        System.out.format("%08d%n",12);
        System.out.printf("%08d\n",18);
        System.out.printf("%d\n",5>>1);
        System.out.printf("pro %d\n",5<<2);
        String a="c";
        String b = "b";
        System.out.println("com "+a.compareTo(b));
        //String string = "Helloworld";
        //System.out.println(string.substring(3,string.length()));
        int x = 20;
        int y = 1;
        //System.out.println(~29);
        //Arrays.binarySearch();
        System.out.println("b");
        for(int i=1;i<10;i++){
            System.out.println(1<<i);
        }
    }
}
