/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast != null && fast.next != null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != fast) {
            return null;
        }

        if (slow == slow.next) {
            return slow;
        }

        ListNode p = head;
        ListNode q = slow.next;

        while (p != q) {
            if (p == slow) {
                p = slow.next;
            }
            if (q == slow) {
                q = head;
            }
            p = p.next;
            q = q.next;
        }

        return p;
    }
}