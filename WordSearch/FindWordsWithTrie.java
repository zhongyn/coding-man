import java.util.*;

public class FindWordsWithTrie {
    public List<String> findWords(char[][] board, String[] words) {
        int maxLen = 0;
        for (String w : words) {
            if (w.length() > maxLen) {
                maxLen = w.length();
            }
        }
        WordDict dict = new WordDict(board, maxLen);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (dict.searchWord(words[i])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] table = {{'a', 'a'}, {'b', 'c'}};
        String[] s = {"aacb", "c"};
        char[][] a = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};
        String[] b = {"abbbababaa"};
        FindWordsWithTrie fw = new FindWordsWithTrie();
        // System.out.println(fw.findWords(table, s));
        System.out.println(fw.findWords(a, b));
    }
}

class WordDict {
    private static class Node {
        private Node[] map = new Node[26];
    }

    private Node root;
    private char[][] table;
    private int maxLen;

    public WordDict(char[][] board, int len) {
        root = new Node();
        table = board;
        maxLen = len;
        buildDict();
    }

    private void buildDict() {
        boolean[][] visited = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                initArray(visited);
                build(i, j, visited, root, 1);
            }
        }        
    }

    private void initArray(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private void build(int i, int j, boolean[][] visited, Node node, int depth) {
        if (i < 0 || i == table.length || j < 0 || j == table[0].length || visited[i][j] || depth > maxLen) {
           return;
        }
 
        char c = table[i][j];
        if (node.map[c - 'a'] == null) {
            node.map[c - 'a'] = new Node();
        }
        Node child = node.map[c - 'a'];

        visited[i][j] = true;
        build(i + 1, j, visited, child, depth + 1);
        build(i, j - 1, visited, child, depth + 1);
        build(i - 1, j, visited, child, depth + 1);
        build(i, j + 1, visited, child, depth + 1);
        visited[i][j] = false;
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