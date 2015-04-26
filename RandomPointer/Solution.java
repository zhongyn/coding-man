/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode h = new RandomListNode(head.label);
        RandomListNode cur = h;

        while (head.next != null) {
            cur.next = new RandomListNode(head.next.label);
            cur = cur.next;
            head = head.next;
        }

        RandomListNode p = head;
        RandomListNode pp = h;
        while (p != null) {
            if (p.random != null) {
                RandomListNode p1 = head;
                RandomListNode p2 = h;
                while (p1 != null && p1 != p.random) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                pp.random = p2;
            }
            p = p.next;
            pp = pp.next;
        }

        return h;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode base = new RandomListNode(0);
        RandomListNode cur = base;
        RandomListNode p = head;

        while (p != null) {
            cur.next = new RandomListNode(p.label);
            map.put(p, cur.next);
            cur = cur.next;
            p = p.next;
        }

        p = head;
        cur = base;
        while (p != null) {
            if (p.random != null) {
                cur.next.random = map.get(p.random);
            }
            p = p.next;
            cur = cur.next;
        }

        return base.next;

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        RandomListNode cur;

        while (p != null) {
            cur = new RandomListNode(p.label);
            cur.next = p.next;
            p.next = cur;
            p = cur.next;
        }

        p = head;
        while (p != null) {
            cur = p.next;
            if (p.random != null) {
                cur.random = p.random.next;
            }
            p = cur.next;
        }

        RandomListNode base = new RandomListNode(0);
        cur = base;
        cur.next = head;
        p = head;
        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }

        return base.next;
    }
}