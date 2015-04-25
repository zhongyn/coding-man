/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode base = new ListNode(0);
        ListNode cur = base;

        while (head != null && head.next != null) {
            cur.next = head.next;
            head.next = cur.next.next;
            cur.next.next = head;
            cur = head;
            head = head.next;
        }

        return base.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode base = head.next;
        head.next = swapPairs(base.next.next);
        base.next = head;
        return base;
    }
}