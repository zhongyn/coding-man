import java.util.*;
public class Solution {
    private class Node {
        int id;
        Node prev;
        Node next;
        Node(int val) {
            id = val;
        }
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        List<Node> table = new ArrayList<>();
        int id = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = nums[i] - 1;
                int right = nums[i] + 1;
                Node cur = new Node(id);
                id++;
                map.put(nums[i], cur);
                table.add(cur);
                if (map.containsKey(left)) {
                    Node p = map.get(left);
                    p.next = cur;
                    cur.prev = p;
                }
                if (map.containsKey(right)) {
                    Node n = map.get(right);
                    n.prev = cur;
                    cur.next = n;
                }
            }
        }

        int maxSeq = 0;

        for (int i = 0; i < table.size(); i++) {
            Node cur = table.get(i);
            if (cur != null) {
                int len = 1;
                Node p = cur.prev;
                Node n = cur.next;
                table.set(cur.id, null);
                while (p != null) {
                    len++;
                    Node t = p.prev;
                    table.set(p.id, null);
                    p = t;
                }
                while (n != null) {
                    len++;
                    Node t = n.next;
                    table.set(n.id, null);
                    n = t;
                }
                maxSeq = Math.max(maxSeq, len);
            }
        }

        return maxSeq;
    }

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        Solution so = new Solution();
        System.out.println(so.longestConsecutive(a));
    }
}