import java.util.*;

class Node {
    char val;
    boolean wordEnd;
    Map<Character, Node> map = new HashMap<>();

    public Node() {}

    public Node(char v) {
        val = v;
    }
}

public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.map.containsKey(c)) {
                node.map.put(c, new Node(c));
            }
            node = node.map.get(c);
        }
        node.wordEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return backtrack(word, root);
    }

    public boolean backtrack(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node n : node.map.values()) {
                    if (backtrack(word.substring(i + 1), n)) {
                        return true;
                    } 
                }
                return false;
            } else {
                if (!node.map.containsKey(c)) {
                    return false;
                } 
                node = node.map.get(c);
            }
        }
        return node.wordEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("word");
        boolean re = wordDictionary.search("wor");    
        System.out.println(re);
    }

}
