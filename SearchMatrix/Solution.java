public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int m = (start + end) / 2;
            int c = m % col;
            int r = m / col;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
       if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = col - 1;

        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        Solution so = new Solution();
        System.out.println(so.searchMatrix1(m, 10));
    }
}