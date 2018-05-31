package numeric;

import java.util.Vector;

/**
 * Created by parcpaes on 06/05/2018.
 */
public class criba {
    public static void main(String arg[]){
        Vector<Integer> primes = new Vector<>();
        int n=20;
        boolean isprime[] = new boolean[n+1];
        for(int i=2;i<=Math.sqrt(n);i++){
            if(!isprime[i]){
                primes.add(i);
                for(int j=i;j<=(n/i);j++){
                    isprime[i*j]=true;
                }
            }
        }

            System.out.println(primes.get(primes.size()-1));

    }
}
