package recursive;
import java.util.*;
/**
 * Created by parcpaes on 15/03/2018.
 */
public class StringPermutation {
    public void permute(char input[]){
        Map<Character, Integer> countMap = new TreeMap<>();
        for(char ch: input){
            countMap.compute(ch, (key, val) -> {
                if(val == null)  return 1;
                else return val + 1;
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            str[index] =entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char result[] = new char[input.length];
        permuteUtil(str,count, result, 0);
    }
    public void permuteUtil(char str[], int count[], char result[],int level){
        if(level == result.length){
            printArray(result);
            return;
        }
        for(int i=0; i< str.length; i++){
            if(count[i] == 0){
                continue;
            }
            result[level] = str[i];
            count[i]--;
            System.out.println("level "+level);
            System.out.println("i "+i+" "+count[i]);
            permuteUtil(str,count,result, level+1);
            count[i]++;
            System.out.println(i+" "+count[i]);
        }
    }
    private void printArray(char input[]){
        for(char ch: input){
            System.out.print(ch);
        }
        System.out.println();
    }
    public static void main(String arg[]){
        StringPermutation sp = new StringPermutation();
        sp.permute("AABC".toCharArray());
    }
}
