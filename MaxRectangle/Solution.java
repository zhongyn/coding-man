import java.util.*;
public class Solution {
    public int maximalRectangle1(char[][] matrix) {
        int row = matrix.length + 1;
        if (row == 1) {
            return 0;
        }
        int col = matrix[0].length + 1;
        boolean[][][][] table = new boolean[row][col][row][col];
        int maxArea = 0;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    table[i - 1][j - 1][i][j] = true;
                    maxArea = Math.max(maxArea, 1);
                    for (int w = 0; w < j - 1; w++) {
                        if (table[i - 1][w][i][j - 1]) {
                            table[i - 1][w][i][j] = true;
                            maxArea = Math.max(maxArea, j - w);
                            for (int h = 0; h < i - 1; h++) {
                                if (table[h][w][i - 1][j]) {
                                    table[h][w][i][j] = true;
                                    maxArea = Math.max(maxArea, (j - w) * (i - h));
                                }
                            }
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(table));
        return maxArea;
    }

    public int maximalRectangle2(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][][] table = new int[row + 1][col + 1][2];
        int maxArea = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    table[i][j][0] = table[i - 1][j][0] + 1;
                    table[i][j][1] = table[i][j - 1][1] + 1;
                }
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int maxw = table[i][j][1];
                for (int h = 0; h < table[i][j][0]; h++) {
                    maxw = Math.min(maxw, table[i - h][j][1]);
                    maxArea = Math.max(maxArea, (h + 1) * maxw);
                }
                
            }
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[] table = new int[col];
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                table[j] = matrix[i][j] == '1' ? table[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(table));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : height[i];
            while (stack.size() > 1 && height[stack.peek()] > h) {
                int hei = height[stack.pop()];
                maxArea = Math.max(maxArea, hei * (i - stack.peek() - 1));
            }
            while (i < len - 1 && height[i] == height[i + 1]) {
                i++;
            }
            stack.push(i);
        }
        return maxArea;
    }


    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] table = new int[row + 1][col + 1];
        int maxWidth = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    table[i][j] = Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1])) + 1;
                    maxWidth = Math.max(maxWidth, table[i][j]);
                }
            }
        }
        return maxWidth * maxWidth;
    }

    public static void main(String[] args) {
        char[][] a = {{'1','0','1','1'}, {'0','1','1','1'}, {'1','0','0','1'}};
        char[][] b = {{'0','1','1','0','1'}, {'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
        char[][] c = {{'1','1','1','1'}, {'1','1','1','1'}, {'1','1','1','1'}};
        Solution so = new Solution();
        System.out.println(so.maximalRectangle(c));
        System.out.println(so.maximalSquare(a));
    }
}