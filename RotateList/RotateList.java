
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {     
        if (head == null) {
            return null;
        }

        ListNode lastNode = head;
        int len = 1;
        while (lastNode.next != null) {
            len++;
            lastNode = lastNode.next;
        }

        System.out.println("len: "+len);
        k = k % len;
        System.out.println(k);

        if (k == 0) {
            return head;
        }

        lastNode.next = head;

        for (int i = 1; i < len - k; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        RotateList s = new RotateList();
        ListNode head = s.rotateRight(a, 2);
        System.out.println(head.val);
    }

}