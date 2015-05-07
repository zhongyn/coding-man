import java.util.*;
public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<List<Integer>> allPaths = backtrack(n, n);
        System.out.println(allPaths);
        List<String[]> result = new ArrayList<>();
        for (List<Integer> p : allPaths) {
            result.add(drawPattern(p, n));
        }
        return result;
    }

    public String[] drawPattern(List<Integer> p, int n) {
        String[] chess = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            sb.setCharAt(p.get(i), 'Q');
            chess[i] = sb.toString();
            sb.setCharAt(p.get(i), '.');
            System.out.println(chess[i]);
        }
        System.out.println();
        return chess;
    }

    public List<List<Integer>> backtrack(int rows, int col) {
        if (col == 0) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }

        List<List<Integer>> pre = backtrack(rows, col - 1);
        List<List<Integer>> cur = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (List<Integer> pattern : pre) {
                if (!hasConflict(i, pattern)) {
                    List<Integer> p = new ArrayList<>(pattern);
                    p.add(i);
                    cur.add(p);
                }
            }
        }
        return cur;
    }

    public boolean hasConflict(int r, List<Integer> pattern) {
        for (int i = 0; i < pattern.size(); i++) {
            int x = pattern.size() - i;
            int y = pattern.get(i) - r;
            if (y == 0 || Math.abs(y) == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 9;
        Solution so = new Solution();
        so.solveNQueens(n);
    }
}