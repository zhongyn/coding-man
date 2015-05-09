import java.util.*;

class Node {
    String word;
    int cost;
    List<Node> next;

    public Node(String s) {
        word = s;
        cost = 1;
        next = new ArrayList<>();
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Map<String, Node> map = createGraph(beginWord, endWord, wordDict);
        Node root = map.get(beginWord);
        Node target = map.get(endWord);
        Queue<Node> frontier = new LinkedList<>();
        Set<Node> explored = new HashSet<>();
        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if (node == target) {
                return node.cost;
            }
            explored.add(node);
            for (Node n : node.next) {
                if (!explored.contains(n) && !frontier.contains(n)) {
                    n.cost = node.cost + 1;
                    frontier.add(n);
                }
            }
        }
        return 0;
    }

    public Map<String, Node> createGraph(String beginWord, String endWord, Set<String> wordDict) {
        Map<String, Node> map = new HashMap<>();
        map.put(beginWord, new Node(beginWord));
        map.put(endWord, new Node(endWord));

        for (String s : wordDict) {
            map.put(s, new Node(s));
        }

        for (String s : wordDict) {
            addNeighbor(map.get(s), map);
        }
        return map;
    }

    public void addNeighbor(Node node, Map<String, Node> map) {
        for (int i = 0; i < node.word.length(); i++) {
            char[] array = node.word.toCharArray();
            for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
                String test = new String(array);
                if (!test.equals(node.word) && map.containsKey(test)) {
                    node.next.add(map.get(test));
                }
            }
        }
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String d = "acs";
        String c = "c";
        Set<String> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);

        Solution so = new Solution();
        System.out.println(so.ladderLength(a, c, set));
    }
}