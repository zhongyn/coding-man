import java.util.*;

public class WordSearch {

    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        List<String> result = new ArrayList<>();

        for (int k = 0; k < words.length; k++) {
            fillArray(visited);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (backtrack(board, words[k], visited, i, j)) {
                        result.add(words[k]);
                    }
                }
            }
        }
        return result;
    }

    public void fillArray(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
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
    String[] s = {"aacb", "aa"};
    WordSearch so = new WordSearch();
    System.out.println(so.findWords(table, s));
}
}

