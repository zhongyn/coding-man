import java.util.*;
public class UniqueConsecutiveLetters {
    private class Node {
        char ch;
        int count;
        Node(char c, int n) {
            ch = c;
            count = n;
        }
    }

    public String permutation(String s) {
        Map<Character, Node> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).count += 1;
            } else {
                map.put(c, new Node(c, 1));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return b.count - a.count;
            }
        });

        pq.addAll(map.values());

        StringBuilder sb = new StringBuilder() ;

        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            if (sb.length() == 0 || a.ch != sb.charAt(sb.length() - 1)) {
                sb.append(a.ch);
                sb.append(b.ch);
            } else {
                sb.append(b.ch);
                sb.append(a.ch);
            }
            a.count--; b.count--;
            if (a.count > 0) {
                pq.offer(a);
            }
            if (b.count > 0) {
                pq.offer(b);
            }
        }

        if (pq.size() > 0) {
            sb.append(pq.poll().ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        UniqueConsecutiveLetters so = new UniqueConsecutiveLetters();
        String a = "BACCBBAAA";
        System.out.println(so.permutation(a));
    }
}