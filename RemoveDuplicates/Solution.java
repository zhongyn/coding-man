/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = pre.next;

        while (cur != null) {
            while (cur != null && pre.val == cur.val) {
                pre.next = cur.next;
                cur = pre.next;
            }
            pre = cur;
            if (pre != null) {
                cur = pre.next;
            } else {
                break;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


}


