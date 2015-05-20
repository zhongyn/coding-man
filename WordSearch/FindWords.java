import java.util.*;

public class FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        WordDict dict = new WordDict();
        buildDict(board, dict);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (dict.searchWord(words[i])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    public void buildDict(char[][] board, WordDict dict) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                build(board, i, j, "", dict, visited);
            }
        }
    }

    public void build(char[][] board, int i, int j, String s, WordDict dict, boolean[][] visited) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j]) {
            dict.addWord(s);
            return;
        }
        visited[i][j] = true;
        s += board[i][j];
        build(board, i + 1, j, s, dict, visited);
        build(board, i, j - 1, s, dict, visited);
        build(board, i - 1, j, s, dict, visited);
        build(board, i, j + 1, s, dict, visited);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] table = {{'a', 'a'}, {'b', 'c'}};
        String[] s = {"aacb", "c"};
        char[][] a = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};
        String[] b = {"abbbababaa"};
        FindWords fw = new FindWords();
        // System.out.println(fw.findWords(table, s));
        System.out.println(fw.findWords(a, b));
    }
}

class WordDict {
    private static class Node {
        private Node[] map = new Node[26];
    }

    private Node root;

    public WordDict() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.map[c - 'a'] == null) {
                node.map[c - 'a'] = new Node();
            }
            node = node.map[c - 'a'];
        }
    }


    public boolean searchWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.map[c - 'a'] == null) {
                return false;
            }
            node = node.map[c - 'a'];
        }
        return true;
    }
}