import java.util.*;
class Node {
    int x;
    int y;
    public Node(int nx, int ny) {
        x = nx;
        y = ny;
    }
}
public class Solution {
    public int numIslands1(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, char[][] grid) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(new Node(i, j));

        while (!frontier.isEmpty()) {
            Node cur = frontier.remove();
            int x = cur.x;
            int y = cur.y;
            grid[x][y] = '0';
            if (x > 0 && grid[x - 1][y] == '1') {
                frontier.add(new Node(x - 1, y));
            }    
            if (x < grid.length - 1 && grid[x + 1][y] == '1') {
                frontier.add(new Node(x + 1, y));
            }    
            if (y > 0 && grid[x][y - 1] == '1') {
                frontier.add(new Node(x, y - 1));
            }    
            if (y < grid[0].length - 1 && grid[x][y + 1] == '1') {
                frontier.add(new Node(x, y + 1));
            }    
        }
    }

    public static void main(String[] args) {
        char[][] g = {{'1','1','0'}, {'0','1','0'}, {'1','0','1'}};
        Solution s = new Solution();
        System.out.println(s.numIslands(g));
    }
}