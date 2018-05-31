package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parcpaes on 16/04/2018.
 */
class Solution {
    public List<List<Integer>> mem = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            mem.add(new ArrayList<>(Arrays.asList(1)));
            return new ArrayList<>(Arrays.asList(1));
        }
        if(mem.size()>rowIndex) return mem.get(rowIndex);

        List<Integer> lista = getRow(rowIndex-1);
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        for(int j=0;j<lista.size()-1;j++){
            newList.add(lista.get(j)+lista.get(j+1));
        }
        newList.add(1);
        mem.add(newList);
        return newList;
    }
}

public class knpascal {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int rowIndex = Integer.parseInt(line);

            List<Integer> ret = new Solution().getRow(rowIndex);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
