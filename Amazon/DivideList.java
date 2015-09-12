// 1->2->3->4 => 1->3->2->4
// 1->2->3->4->5 => 1->3->2->4->5

class ListNode {
    int val;
    ListNode next;
    ListNode(int v) {
        val = v;
    }
}

class DivideList {
    public ListNode divide(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;
        slow = head;

        while (slow.next != null) {
            ListNode tmp = fast;
            fast = fast.next;
            tmp.next = slow.next;
            slow.next = tmp;
            slow = tmp.next;
        }
        slow.next = fast;

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        printList(a);
        DivideList so = new DivideList();
        printList(so.divide(a));
    }

}
