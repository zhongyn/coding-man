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

    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][col - 1] == 'O') {
                dfs(i, col - 1, board);
            }
        }

        for (int i = 1; i < col - 1; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[row - 1][i] == 'O') {
                dfs(row - 1, i, board);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(i, 0, board);
            }
            if (board[i][col - 1] == 'O') {
                bfs(i, col - 1, board);
            }
        }

        for (int i = 1; i < col - 1; i++) {
            if (board[0][i] == 'O') {
                bfs(0, i, board);
            }
            if (board[row - 1][i] == 'O') {
                bfs(row - 1, i, board);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(int i, int j, char[][] grid) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(new Node(i, j));

        while (!frontier.isEmpty()) {
            Node cur = frontier.remove();
            int x = cur.x;
            int y = cur.y;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 'O') {
                grid[x][y] = '1';
                frontier.add(new Node(x - 1, y));
                frontier.add(new Node(x + 1, y));
                frontier.add(new Node(x, y - 1));
                frontier.add(new Node(x, y + 1));
            }    
        }
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 'O') {
            return;
        }
        grid[i][j] = '1';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }

    public void dfs(int i, int j, char[][] grid) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(new Node(i, j));

        while (!frontier.isEmpty()) {
            Node cur = frontier.pop();
            int x = cur.x;
            int y = cur.y;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 'O') {
                grid[x][y] = '1';
                frontier.push(new Node(x - 1, y));
                frontier.push(new Node(x + 1, y));
                frontier.push(new Node(x, y - 1));
                frontier.push(new Node(x, y + 1));
            }    
        }
    }

    public static void main(String[] args) {
        char[][] g = {{'O','X','X','O'}, {'X','O','O','X'}, {'O','X','X','O'}, {'O','O','O','X'}};
        // char[][] g = {{'O','X','O'}, {'X','O','X'}, {'O','X','O'}};
        char[][] b = {{'O','O'},{'O','O'}};
        Solution s = new Solution();
        s.solve(g);
        for (char[] row : g) {
            System.out.println(row);
        }

    }
}