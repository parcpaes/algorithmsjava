package recursive;

public class ex1 {
    public static void ex233(int n){
        if(n<=0) return ;
        System.out.println(n);
        ex233(n-2);
        ex233(n-3);
        System.out.println(n);
    }
    public static String ex234(int n){
        if(n<=0) return "";
        return ex234(n-3) + n + ex234(n-2)+n;
    }
    public static void main(String arg[]){
        //ex233(6);
        System.out.println(ex234(6));
    }
}
