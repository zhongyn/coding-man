/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode base = new ListNode(0);
        ListNode p = base;
        p.next = head;

        for (int i = 1; i < m; i++) {
            p = p.next;
        }

        ListNode cur = p.next;
        ListNode endOfReverseList = cur;
        ListNode pre = null;
        ListNode tmp;

        for (int i = m; i <= n; i++) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        p.next = pre;
        endOfReverseList.next = cur;
        return base.next;
    }
}