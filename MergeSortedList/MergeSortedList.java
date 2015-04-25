/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = p2;
                p2 = p2.next;
            }
        }

        cur.next = p1 != null? p1 : p2;
        return head.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2;
                break;
            }
            if (p2 == null) {
                cur.next = p1;
                break;
            }
            if (p1.val <= p2.val) {
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = p2;
                p2 = p2.next;
            }
        }
        return head.next;
    }
}