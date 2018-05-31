package recursive;

public class TowersHanoi {
    public static void moves(int n, boolean left){
        if(n==0) return;
        if(left) System.out.println(n+" left");
        moves(n-1, !left);
        moves(n-1,!left);

        if(!left) System.out.println(n+" right");
    }

    public static void main(String[] arg){
        int n = 4;
        moves(n,true);
    }
}
