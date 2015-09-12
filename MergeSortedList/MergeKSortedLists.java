/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        Comparator<ListNode> comp = new NodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, comp);
        ListNode base = new ListNode(0);
        ListNode cur = base;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        while (queue.size() > 0) {
            cur.next = queue.poll();
            if (cur.next.next != null) {
                queue.add(cur.next.next);
            }
            cur = cur.next;
        }

        return base.next;
    }

}

class NodeComparator implements Comparator<ListNode> {
    
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}