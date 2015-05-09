import java.util.*;

class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean wordEnd;
    Map<Character, TrieNode> next = new HashMap<>();

    public TrieNode() {
    }

    public TrieNode(char c) {
        val = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TrieNode(c));
            }
            node = node.next.get(c);
        }
        node.wordEnd = true;
    }

    // Returns the end node if there is any word in the trie
    // that starts with the given prefix.

    public TrieNode find(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next.containsKey(c)) {
                node = node.next.get(c);
            } else {
                return null;
            }
        } 
        return node;       
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = find(word);
        return node == null ? false : node.wordEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = find(word);
        return node == null;        
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("somestring");
        trie.search("key");        
        System.out.println(trie.search("somestrin"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");