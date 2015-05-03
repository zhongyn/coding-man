
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReorderList {
    public void reorderList1(ListNode head) {
        reorderSubList(head);
    }

    public ListNode reorderSubList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode subLast = head;
        while (subLast.next.next != null) {
            subLast = subLast.next;
        }

        ListNode last = subLast.next;
        subLast.next = null;
        last.next = reorderSubList(head.next);
        head.next = last;
        return head;        
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode m = findMiddle(head);
        ListNode right = m.next;
        m.next = null;
        mergeLists(head, reverseList(right));   
    }
    
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;        
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public void mergeLists(ListNode left, ListNode right) {
        ListNode tmp;
        while (right != null) {
            tmp = right;
            right = right.next;
            tmp.next = left.next;
            left.next = tmp;
            left = tmp.next;
        }
    }

    private ListNode newHead;
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            newHead = head;
            return head;
        }

        ListNode tail = reverseList(head.next);
        tail.next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        ListNode base = new ListNode(0);
        ListNode cur = base;
        for (int i = 0; i < a.length; i++) {
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        // base.next = null;
        // ListNode base = new ListNode(4);
        // ListNode b = new ListNode(3);
        // ListNode c = new ListNode(1);
        // ListNode d = new ListNode(-2);
        // base.next = b;
        // b.next = c;
        // c.next = d;

        ReorderList so = new ReorderList();
        so.reorderList(base);
        // base = so.reverseList(base);
        // base = so.newHead;
        while (base != null) {
            System.out.println(base.val);
            base = base.next;
        }
    }
}