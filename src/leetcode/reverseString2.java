package leetcode;

/**
 * Created by parcpaes on 07/05/2018.
 * 541
 */
public class reverseString2 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0, j;
        while(i < n) {
            j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += (k<<1);
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
