import java.util.*;

public class SearchByTrie {

    private WordDict dict;
    private char[][] table;
    private Set<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        dict = new WordDict();
        result = new HashSet<>();
        table = board;

        for (int i = 0; i < words.length; i++) {
            dict.addWord(words[i]);
        }

        boolean[][] visited = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                backtrack(i, j, "", visited);
            }
        }
        return new ArrayList<>(result);
    }

    public void backtrack(int i, int j, String s, boolean[][] visited) {
        if (i < 0 || i == table.length || j < 0 || j == table[0].length || visited[i][j]) {
            return;
        }
        s += table[i][j];
        if (!dict.searchPrefix(s)) {
            return;
        }
        if (dict.searchWord(s)) {
            result.add(s);
        }
        visited[i][j] = true;
        backtrack(i + 1, j, s, visited);
        backtrack(i, j - 1, s, visited);
        backtrack(i - 1, j, s, visited);
        backtrack(i, j + 1, s, visited);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] table = {{'a', 'a'}, {'b', 'c'}};
        String[] s = {"aacb", "c"};
        char[][] a = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};
        String[] b = {"abbbababaa", "bba"};
        SearchByTrie fw = new SearchByTrie();
        // System.out.println(fw.findWords(table, s));
        System.out.println(fw.findWords(a, b));

        // WordDict dict = new WordDict();
        // dict.addWord("abc");
        // System.out.println(dict.searchPrefix("d"));
        // System.out.println(dict.searchWord("abc"));
        
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
        return node != null;
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