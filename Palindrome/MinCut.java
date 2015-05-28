import java.util.*;
public class MinCut {
    public int minCut(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] table = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            table[i] = len;
        }

        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (i == 0) {
                    isPalindrome[j][j + i] = true;
                } else if (s.charAt(j) == s.charAt(j + i)) {
                    if (i == 1 || isPalindrome[j + 1][j + i - 1]) {
                        isPalindrome[j][j + i] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (table[j] + 1 < table[i] && isPalindrome[j][i - 1]) {
                    table[i] = table[j] + 1;
                }
            }
        }

        return table[len] - 1;
    }

    public boolean isPalindrome1(char[] A, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            if (A[start + i] != A[end - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="abc";
        MinCut p = new MinCut();
        System.out.println(p.minCut(s));
    }

}