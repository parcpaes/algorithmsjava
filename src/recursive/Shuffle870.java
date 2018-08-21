package recursive;

import java.util.*;

public class Shuffle870 {
    public static class Pair{
        int first, second;
        Pair(int a, int b){
            first = a;
            second = b;
        }
    }
    public int[] advantageCount(int[] A, int[] B){
        Map<Pair,Integer> vals = new HashMap<>();
        int size = A.length;
        int result[] = new int[size];

        for(int i=0;i<size;i++) vals.put(new Pair(B[i],A[i]),i);
        Arrays.sort(A);
        Arrays.sort(B);
        List<Pair> greater = new ArrayList<>();
        int j=0;
        for(int i=0;i<size;i++){
            Pair p = new Pair(B[j], A[i]);
            if(A[i]>B[j]){
                System.out.println(vals.get(p));
                result[vals.get(p)] = A[i];
                vals.remove(p);
                j++;
            }else{
                greater.add(p);
            }
        }
        j=0;
        return result;
    }
    public static void main(String arg[]){
        Shuffle870 shuffle = new Shuffle870();
        int array1[] = {2,0,4,1,2};
        int array2[] = {1,3,0,0,2};
        System.out.println(Arrays.toString(shuffle.advantageCount(array1,array2)));
    }
}
