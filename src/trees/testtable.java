package trees;

import java.util.Scanner;

public class testtable {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        ST<String, Integer> st = new ST<>();
        for(int i=0;i<10;i++){
            String key = in.nextLine();
            st.put(key,i);
        }
    }
}
