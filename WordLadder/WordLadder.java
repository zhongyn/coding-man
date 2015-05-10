import java.util.*;

class Node {
    String word;
    int cost;

    public Node(String s) {
        word = s;
        cost = 1;
    }
}

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<Node> frontier = new LinkedList<>();
        Node root = new Node(beginWord);
        frontier.add(root);
        wordDict.add(endWord);

        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (node.word.equals(endWord)) {
                return node.cost;
            }
            Node child = getChild(node, wordDict);
            while (child != null) {
                frontier.add(child);
                wordDict.remove(child.word);
                child = getChild(node, wordDict);
            }
        }
        return 0;
    }

    public Node getChild(Node parent, Set<String> wordDict) {
        Node child = null;
        for (int i = 0; i < parent.word.length(); i++) {
            char[] array = parent.word.toCharArray();
            for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
                String test = new String(array);
                if (wordDict.contains(test)) {
                    child = new Node(test);
                    child.cost = parent.cost + 1;
                    return child;
                }
            }
        }
        return child;
    }


    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String d = "acs";
        String c = "c";
        Set<String> set = new HashSet<>();
        set.add(a);
        set.add(b);
        // set.add(c);

        WordLadder so = new WordLadder();
        System.out.println(so.ladderLength(a, c, set));
    }
}