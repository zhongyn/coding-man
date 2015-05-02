
  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode m = findMiddle(head);
        ListNode rightList = m.next;
        m.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightList);

        return mergeTwoLists(left, right);
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }

        ListNode base = new ListNode(0);
        base.next = head;
        ListNode tail;
        ListNode tmp = null;
        ListNode a1, a2, b1, b2;


        for (int i = 1; i < len; i <<= 1) {
            a1 = base.next;
            tail = base;

            while (a1 != null) {
                a2 = forward(a1, i - 1);
                b1 = a2.next;
                b2 = forward(b1, i - 1);
                if (b2 != null) {
                    tmp = b2.next;
                    b2.next = null;
                } else {
                    tmp = null;
                }
                a2.next = null;
                tail.next = mergeTwoLists(a1, b1);
                tail = findTail(tail.next);
                a1 = tmp;
            }
        }

        return base.next;
    }

    public ListNode forward(ListNode node, int shift) {
        int i = 0;
        while (node != null && node.next != null && i < shift) {
            node = node.next;
            i++;
        }
        return node;
    }

    public ListNode findTail(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public ListNode findMiddle1(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        for (int i = 0; i < (len - 1) / 2; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


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

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(-2);
        a.next = b;
        b.next = c;
        c.next = d;

        Solution so = new Solution();
        ListNode re = so.sortList(a);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }
}
