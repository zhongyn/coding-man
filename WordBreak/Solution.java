import java.util.*;

public class Solution {
    public boolean wordBreak1(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(i);
            if (wordDict.contains(s.substring(j, i + 1))) {
                boolean result = wordBreak1(s.substring(i + 1), wordDict);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak2(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i + 1))) {
                    breakable[i + 1] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }

    public List<String> wordBreak4(String s, Set<String> wordDict) {
        int len = s.length();
        if (len == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        List<String> words = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            String current = s.substring(0, i);
            if (wordDict.contains(current)) {
                List<String> remain = wordBreak4(s.substring(i, len), wordDict);
                for (String w : remain) {
                    words.add(current + (w.isEmpty() ? "" : " ") + w);
                    
                }
            }
            
        }        
        return words;
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        List<String> last = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i + 1))) {
                    breakable[i + 1] = true;
                    break;
                }
            }
        }
        if (!breakable[s.length()]) {
            return last;
        }

        Map<Integer, List<String>> map = new HashMap<>();
        int len = s.length();
        last.add("");
        map.put(len, last);

        for (int i = len - 1; i >= 0; i--) {
            List<String> cur = new ArrayList<>();
            for (int j = i + 1; j <= len; j++) {
                String w = s.substring(i, j);
                if (wordDict.contains(w) {
                    for (String word : map.get(j)) {
                        cur.add(w + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            map.put(i, cur);
        }
        return map.get(0);
    }



    public List<String> wordBreak3(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < breakable.length; i++) {
            if (breakable[i]) {
                map.put(i, new Node(i));   
            }            
        }

        for (int i = 0; i < breakable.length; i++) {
            if (breakable[i]) {
                for (int j = i + 1; j < breakable.length; j++) {
                    if (breakable[j] && wordDict.contains(s.substring(i, j))) {
                        map.get(i).next.add(map.get(j));
                    }
                }
            }
        }

        findAllPaths(map.get(0), map.get(s.length()));
        List<List<Node>> paths = map.get(0).pathsToTarget;
        List<String> result = new ArrayList<>();
        for (List<Node> path : paths) {
            result.add(constructSentence(s, path));
        }
        return result;
    }

    public boolean findAllPaths(Node root, Node target) {
        if (root == target) {
            root.pathsToTarget.add(new ArrayList<>());
            return true;
        }

        boolean hasPath = false;
        for (Node neig : root.next) {
            if (findAllPaths(neig, target)) {
                for (List<Node> path : neig.pathsToTarget) {
                    List<Node> p = new ArrayList<>(path);
                    p.add(root);
                    root.pathsToTarget.add(p);
                }
                hasPath = true;
            }
        }
        return hasPath;
    }

    public String constructSentence(String s, List<Node> path) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = path.size() - 2; i >= 0; i--) {
            int point = path.get(i).val;
            sb.append(s.substring(start, point));
            sb.append(" ");
            start = point;
        }
        sb.append(s.substring(start, s.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "superhero";
        String a = "aaaaaaaa";

        Set<String> dict = new HashSet<>();
        // dict.add("super");
        // dict.add("hero");
        // dict.add("aa");
        dict.add("aaaa");
        dict.add("aaa");
        dict.add("aa");

        Solution so = new Solution();
        List<String> re = so.wordBreak(a, dict);
        // List<String> re = so.wordBreak(s, dict);
        System.out.println(re);
    }
}

class Node {
    int val;
    List<Node> next = new ArrayList<>();
    List<List<Node>> pathsToTarget = new ArrayList<>();

    public Node(int v) {
        val = v;
    }
}