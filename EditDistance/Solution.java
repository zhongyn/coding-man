public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    table[i][j] = j;
                } else if (j == 0) {
                    table[i][j] = i;   
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        table[i][j] = table[i - 1][j - 1];
                    } else {
                        table[i][j] = Math.min(Math.min(table[i - 1][j], table[i][j - 1]), table[i - 1][j - 1]) + 1;
                    }
                }
            }
        }

        return table[m][n];
    }

    public boolean oneEditDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int diff = Math.abs(m - n);

        if (diff > 1) {
            return false;
        }

        if (diff == 0) {
            int diffCount = 0;
            for (int i = 0; i < m; i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
            }
        }

        int a = 0;
        int b = 0;
        if (m - n == 1) {
            while (b < n) {
                if (word1.charAt(a) == word2.charAt(b)) {
                    b++;
                }
                a++;
                if (a - b > 1) {
                    return false;
                }
            }
        } else {
            while (a < m) {
                if (word1.charAt(a) == word2.charAt(b)) {
                    a++;
                }
                b++;
                if (b - a > 1) {
                    return false;
                }
            }

        }
        return true;
    }
    
    public static void main(String[] args) {
        String a = "abc";
        String b = "cde";
        Solution so = new Solution();
        System.out.println(so.minDistance("a", "b"));
    }
}