public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        if (grid[0][0] == '1') {
            count++;
        }
        for (int i  = 1; i < grid[0].length; i++) {
            if (grid[0][i - 1] != '1' && grid[0][i] == '1') {
                count++;
            }
        }
        for (int i  = 1; i < grid.length; i++) {
            if (grid[i - 1][0] != '1' && grid[i][0] == '1') {
                count++;
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j - 1] == '0' && grid[i - 1][j] == '0' && grid[i][j + 1] == '0' && grid[i][j] == '1') {
                      count++;
                  }  
            }
        }

        for (int i = 1; i < grid.length; i++) {
            if (grid[i][grid[0].length - 2] == '0' && grid[i - 1][grid[0].length - 1] == '0' && grid[i][grid[0].length - 1] == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] g = {{'1','1','1'}, {'0','1','0'}, {'1','1','1'}};
        Solution s = new Solution();
        System.out.println(s.numIslands(g));
    }
}