import java.util.*;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees1(int n) {
        return subTrees(1, n);
    }

    public List<TreeNode> subTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            for (TreeNode left : subTrees(start, i - 1)) {
                for (TreeNode right : subTrees(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        List<List<List<TreeNode>>> table = new ArrayList<>(n + 2);
        for (int i = 0; i < n + 2; i++) {
            List<List<TreeNode>> row = new ArrayList<>(n + 2);
            for (int j = 0; j < n + 2; j++) {
                row.add(new ArrayList<>());
            }
            table.add(row);
        }
        for (int i = 1; i < n + 2; i++) {
            table.get(i).get(i - 1).add(null);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                int start = j;
                int end = j + i;
                for (int k = start; k <= end; k++) {
                    for (TreeNode left : table.get(start).get(k - 1)) {
                        for (TreeNode right : table.get(k + 1).get(end)) {
                            TreeNode root = new TreeNode(k);
                            root.left = left;
                            root.right = right;
                            table.get(start).get(end).add(root);
                        }
                    }
                }
            }
        }
        return table.get(1).get(n);
    }

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
        System.out.println(so.numTrees(5));
        List<TreeNode> re = so.generateTrees(5);
        System.out.println(re.size());
    }
}