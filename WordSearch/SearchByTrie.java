import java.util.*;

public class SearchByTrie {

    private WordDict dict;
    private char[][] table;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        dict = new WordDict();
        result = new ArrayList<>();
        table = board;
        int maxLen = 0;

        for (int i = 0; i < words.length; i++) {
            dict.addWord(words[i]);
            maxLen = Math.max(maxLen, words[i].length());
        }

        boolean[][] visited = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                backtrack(i, j, "", visited, maxLen);
            }
        }
        return result;
    }

    public void backtrack(int i, int j, String s, boolean[][] visited, int depth) {
        if (i < 0 || i == table.length || j < 0 || j == table[0].length || visited[i][j] || depth == 0) {
            return;
        }
        visited[i][j] = true;
        s += table[i][j];
        if (!dict.searchPrefix(s)) {
            return;
        }
        if (dict.searchWord(s)) {
            result.add(s);
        }
        backtrack(i + 1, j, s, visited, depth - 1);
        backtrack(i, j - 1, s, visited, depth - 1);
        backtrack(i - 1, j, s, visited, depth - 1);
        backtrack(i, j + 1, s, visited, depth - 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] table = {{'a', 'a'}, {'b', 'c'}};
        String[] s = {"aacb", "c"};
        char[][] a = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};
        String[] b = {"abbbababaa", "bba"};
        FindWords fw = new FindWords();
        // System.out.println(fw.findWords(table, s));
        System.out.println(fw.findWords(a, b));
    }
}

class WordDict {
    private static class Node {
        boolean wordEnd;
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
        node.wordEnd = true;
    }

    public boolean searchWord(String word) {
        Node node = search(word);
        if (node == null) {
            return false;
        }
        return node.wordEnd;
    }

    public boolean searchPrefix(String prefix) {
        Node node = search(prefix);
        return node == null;
    }

    private Node search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.map[c - 'a'] == null) {
                return null;
            }
            node = node.map[c - 'a'];
        }
        return node;
    }
}