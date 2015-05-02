
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode base = new ListNode(0);
        base.next = head;
        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.val >= cur.val) {
                cur = cur.next;
                continue;
            }
            ListNode p = base;
            while (p.next.val < cur.next.val) {
                p = p.next;
            }
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = p.next;
            p.next = tmp;
        }
        return base.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        InsertionSort so = new InsertionSort();
        ListNode re = so.insertionSortList(a);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }

    }
}
