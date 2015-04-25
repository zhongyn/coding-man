
class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
   }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int i = 0;
        int j = 0;

        while (a != null) {
            i++;
            a = a.next;
        }
        while (b != null) {
            j++;
            b = b.next;
        }

        a = headA;
        b = headB;

        while (a != b) {
            if (i > j) {
                a = a.next;
                i--;
            } else if (i < j) {
                b = b.next;
                j--
            } else {
                a = a.next;
                b = b.next;                
            }
        }

        if (a == null) {
            return null;
        }

        return a;
    }
}