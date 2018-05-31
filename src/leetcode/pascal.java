package leetcode;


import java.util.*;
public class pascal {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> passcal = new ArrayList<>();
        if(numRows == 0) return passcal;
        List<Integer> lista;
        passcal.add(Arrays.asList(1));
        for(int i=0;i<numRows-1;i++){
            lista = passcal.get(i);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for(int j=0;j<lista.size()-1;j++){
                newList.add(lista.get(j)+lista.get(j+1));
            }
            newList.add(1);
            passcal.add(newList);
        }
        return passcal;
    }

    public static void main(String arg[]){
        int n = 3;
        System.out.println(generate(n));
    }
}
