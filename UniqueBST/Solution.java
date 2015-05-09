public class Solution {
    public int numTrees1(int n) {
        return backtrack(1, n);
    }

    public int backtrack(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            result += backtrack(start, i - 1) * backtrack(i + 1, end);
        }
        return result;
    }

    public int numTrees2(int n) {
        int[][] table = new int[n + 2][n + 2];
        for (int i = 1; i <= n + 1; i++) {
            table[i][i] = 1;
            table[i][i - 1] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                int start = j;
                int end = j + i;
                for (int k = start; k <= end; k++) {
                    table[start][end] += table[start][k - 1] * table[k + 1][end];
                }
            }        
        }    
        return table[1][n];    
    }

    public int numTrees(int n) {
        int[] A = new int[n + 1];
        A[0] = 1;
        A[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                A[i] += A[j] * A[i - j - 1];
            }
        }
        return A[n];
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.numTrees(3));
    }
}