    import java.util.*;

public class LCP {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        Node root = new Node();

        for (int i = 0; i < strs.length; i++) {
            Node node = root;
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                node.addNode(c);
                node = node.getByChar(c);
            }
        }

        String[] prefix = new String[root.size()];
        int len = -1;
        int maxid = 0;
        for (int i = 0; i < root.size(); i++) {
            prefix[i] = getPrefix(root.getByIndex(i));
            if (prefix[i].length() > len) {
                len = prefix[i].length();
                maxid = i;
            }
        }

        System.out.println(len);
        if (len != -1) {
            System.out.println(root.getByIndex(maxid).count);
            if (root.getByIndex(maxid).count > 1) {
                return prefix[maxid];
            }
        }

        return "";

    }

    public String getPrefix(Node node) {
        int size = node.size();
        if (node.count == 1) {
            return "";
        }
        if (size > 1 || size == 0) {
            return node.val + "";
        }
        return node.val + getPrefix(node.getByIndex(0));
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] s = {"abcd", "abef", "befg", "bdfg"};
        String[] a = {"", "a"};
        LCP test = new LCP();
        System.out.println(test.longestCommonPrefix1(s));
    }

}

class Node {
    char val;
    List<Node> next = new LinkedList<Node>();
    int count = 0;

    public Node() {}

    public Node(char value) {
        val = value;
    }

    public int size() {
        return next.size();
    }

    public void addNode(char value) {
        if (!containsChar(value)) {
            next.add(new Node(value));
        }
        getByChar(value).count += 1;
    }

    public boolean containsChar(char value) {
        for (Node n: next) {
            if (n.val == value) {
                return true;
            }
        }
        return false;
    }

    public Node getByChar(char value) {
        for (Node n : next) {
            if (n.val == value) {
                return n;
            }
        }
        return null;
    }

    public Node getByIndex(int i) {
        return next.get(i);
    }
}