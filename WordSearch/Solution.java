public class Solution {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(board, word, visited, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (word.charAt(0) != board[i][j]) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        visited[i][j] = true;
        String subWord = word.substring(1);
        if (backtrack(board, subWord, visited, i - 1, j)
            || backtrack(board, subWord, visited, i + 1, j)
            || backtrack(board, subWord, visited, i, j - 1)
            || backtrack(board, subWord, visited, i, j + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        char[][] table = {{'a', 'a'}, {'b', 'c'}};
        String s = "aacb";
        Solution so = new Solution();
        System.out.println(so.exist(table, s));
    }
}

