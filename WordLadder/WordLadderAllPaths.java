import java.util.*;

class Node {
    String word;
    int cost;
    Node parent;

    public Node(String s) {
        word = s;
        cost = 1;
    }
}

public class WordLadderAllPaths {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordDict) {
        Queue<Node> frontier = new LinkedList<>();
        Node root = new Node(beginWord);
        frontier.add(root);
        int depth = 1;
        Set<String> garbage = new HashSet<>();
        List<Node> result = new ArrayList<>();
        int shortest = 1;

        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (node.word.equals(endWord)) {
                if (result.isEmpty()) {
                    result.add(node);
                    shortest = node.cost;
                } else if (node.cost == shortest) {
                    result.add(node);
                } else {
                    break;
                }
            }

            if (node.cost > depth ) {
                wordDict.removeAll(garbage);
                garbage.clear();
                depth++;
            }

            List<Node> children = getChildren(node, wordDict);
            frontier.addAll(children);
            for (Node n : children) {
                garbage.add(n.word);
            }

        }

        List<List<String>> allPaths = new ArrayList<>();
        for (Node n : result) {
            allPaths.add(getPath(n, shortest));
        }
        return allPaths;
    }

    public List<String> getPath(Node node, int height) {
        LinkedList<String> path = new LinkedList<>();
        while (node != null) {
            path.addFirst(node.word);
            node = node.parent;
        }
        return path;
    }

    public List<Node> getChildren(Node parent, Set<String> wordDict) {
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < parent.word.length(); i++) {
            char[] array = parent.word.toCharArray();
            for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
                String test = new String(array);
                if (wordDict.contains(test)) {
                    Node child = new Node(test);
                    child.cost = parent.cost + 1;
                    child.parent = parent;
                    children.add(child);
                }
            }
        }
        return children;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "bd";
        String d = "acs";
        String c = "ac";
        Set<String> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);

        WordLadderAllPaths so = new WordLadderAllPaths();
        System.out.println(so.findLadders(a, c, set));
    }
}