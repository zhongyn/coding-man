
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseNodes {
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode base = new ListNode(0);
        ListNode pre = base;

        while (head != null) {
            ListNode cur = head;
            ListNode start = head;
            int count = 1;
            while (cur != null && count < k) {
                cur = cur.next;
                count++;
            }
            if (cur != null) {
                head = cur.next;
                cur.next = null;
                pre.next = reverseList(start);
                pre = start;
            } else {
                pre.next = head;
                break;
            }
        }
        return base.next;
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 1;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (cur == null) {
            return head;
        }

        ListNode end = head;
        ListNode pre = null;
        while (count > 0) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
            count--;
        }
        end.next = reverseKGroup(head, k);
        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ReverseNodes so = new ReverseNodes();
        ListNode re = so.reverseKGroup(a, 2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }

    }
}