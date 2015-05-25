import java.util.*;
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        int base = 1;
        for (int i = 1; i <= n; i++) {
            digits.add(i);
            base *= i;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            base /= n - i;
            int d = binarySearch(n - i, k, base);
            sb.append(digits.get(d - 1));
            digits.remove(d - 1);
            k -= (d - 1) * base;
        }
        return sb.toString();
    }

    public int binarySearch(int n, int k, int base) {
        int i = 0;
        int j = n;

        while (i < j) {
            int m = (i + j) / 2;
            if (m * base >= k) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.getPermutation(3, 5));
    }
}