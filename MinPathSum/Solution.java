public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i -1];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += grid[i - 1][j] < grid[i][j - 1]? grid[i - 1][j] : grid[i][j - 1];
            }
        }

        return grid[row - 1][col - 1];

    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = 1;
        }
 
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        obstacleGrid[0][0] = obstacleGrid[0][0] == 1? 0 : 1;

        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1? 0 : obstacleGrid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1? 0 : obstacleGrid[i - 1][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[m - 1][n - 1];
        
    }

    public static void main(String[] args) {
        int[][] g = {{1,0}};
        Solution s = new Solution();
        System.out.println(s.uniquePathsWithObstacles(g));
    }
}

class Solution {
public:
    int uniquePaths(int m, int n) {
        int table[m + 1][n + 1] = {0};
        table[0][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        
        return table[m][n];
    }
    
    int uniquePaths(int m, int n) {
        int table[n + 1] = {0};
        table[1] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                table[j] = table[j] + table[j - 1];
            }
        }
        return table[n];
    }

    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        vector<vector<int>> t(m + 1, vector<int>(n + 1, 0));
        t[0][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (!obstacleGrid[i - 1][j - 1]) {
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
            }
        }
        return t[m][n];
    }

    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        int t[n + 1] = {0};
        t[1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                t[j] = obstacleGrid[i - 1][j - 1] == 0 ? t[j] + t[j - 1] : 0;
            }
        }
        return t[n];
    }

};