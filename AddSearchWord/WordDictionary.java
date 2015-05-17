import java.util.*;

public class WordDictionary {
    class Node {
        boolean wordEnd;
        Map<Character, Node> map = new HashMap<>();
    }

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
                node.map.put(c, new Node());
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

    private boolean backtrack(String word, Node node) {
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
        boolean re = wordDictionary.search("word");    
        System.out.println(re);
    }

}
