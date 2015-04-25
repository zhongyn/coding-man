/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        int j = 0;
        ListNode head = l1;
        while (head != null) {
            head = head.next;
            i++;
        }
        head = l2;
        while (head != null) {
            head = head.next;
            j++;
        }
        
        ListNode base = new ListNode(0);
        ListNode cur = base;
        cur.next = i > j? l1 : l2;

        int c = 0;
        
        while (cur.next != null) {
            c += l1 != null? l1.val : 0;
            c += l2 != null? l2.val : 0;
            cur.next.val = c % 10;
            c /= 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (c != 0) {
            cur.next = new ListNode(c);
        }
        return base.next;
    }
}