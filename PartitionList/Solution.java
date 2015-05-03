class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode partition2(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = head;
            } else {
                rightTail.next = head;
                rightTail = head;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = rightHead.next;
        return leftHead.next;
    }


    public ListNode partition(ListNode head, int x) {
        ListNode pHead = null, pTail = null;
        ListNode qHead = null, qTail = null;
        ListNode tmp1, tmp2;

        while (head != null) {
            tmp1 = head.next;
            if (head.val < x) {
                if (pHead == null) {
                    pHead = head;
                    pTail = head;
                } else {
                    tmp2 = pTail.next;
                    pTail.next = head;
                    head.next = tmp2;
                    pTail = head;
                }
            } else {
                if (qHead == null) {
                    qHead = head;
                    qTail = head;
                } else {
                    tmp2 = qTail.next;
                    qTail.next = head;
                    head.next = tmp2;
                    qTail = head;
                }
            }
            head = tmp1;
        }

        if (pHead == null && qHead == null) {
            return null;
        }
        if (pHead == null) {
            qTail.next = null;
            return qHead;
        }
        if (qHead == null) {
            pTail.next = null;
            return pHead;
        }
        pTail.next = qHead;
        qTail.next = null;
        return pHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        Solution so = new Solution();
        ListNode re = so.partition(a, 2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }

    }
}