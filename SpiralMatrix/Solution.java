import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length == 0) {
            return spiral;
        }
        int level = matrix.length > matrix[0].length ? (matrix[0].length + 1) / 2 : (matrix.length + 1) / 2;

        for (int i = 0; i < level; i++) {
            int left = i;
            int right = matrix[0].length - i - 1;
            int up = i;
            int down = matrix.length - i - 1;

            for (int j = left; j <= right; j++) {
                System.out.println("j: "+j);
                spiral.add(matrix[up][j]);
            }

            for (int j = up + 1; j <= down; j++) {
                spiral.add(matrix[j][right]);
            }

            if (down == up) {
                break;
            }
            for (int j = right - 1; j >= left; j--) {
                spiral.add(matrix[down][j]);
            }

            if (left == right) {
                break;
            }
            for (int j = down - 1; j > i; j--) {
                spiral.add(matrix[j][left]);
            }
        }

        return spiral;
    }

    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int level = (n + 1) / 2;
        int count = 1;

        for (int i = 0; i < level; i++) {
            int left = i;
            int right = n - i - 1;
            int up = i;
            int down = n - i - 1;

            for (int j = left; j <= right; j++) {
                m[up][j] = count++;
            }

            for (int j = up + 1; j <= down; j++) {
                m[j][right] = count++;
            }

            for (int j = right - 1; j >= left; j--) {
                m[down][j] = count++;
            }

            for (int j = down - 1; j >= up + 1; j--) {
                m[j][left] = count++;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        int[][] k = {{6,7,8}};
        int[][] n = {{6},{7},{8}};

        Solution so = new Solution();
        // System.out.println(so.spiralOrder(n));
        int[][] re = so.generateMatrix(1);
        for (int[] row : re) {
            System.out.println(Arrays.toString(row));
        }
    }

}