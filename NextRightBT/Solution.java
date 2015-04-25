class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode start = root;
        TreeLinkNode p = root;
        TreeLinkNode child;
        TreeLinkNode m;

        while (start != null && (start.left != null || start.right != null)) {
            while (p != null) {
                if (p.left != null && p.right != null) {
                    p.left.next = p.right;
                }

                child = p.right != null? p.right : p.left;
                p = p.next;
                while (p != null) {
                    if (p.left != null) {
                        child.next = p.left;
                        break;
                    } else if (p.right != null) {
                        child.next = p.right;
                        break;
                    }
                    p = p.next;
                }
            }

            m = start.left != null? start.left : start.right;
            System.out.println(m.val);
            while (m != null && m.left == null && m.right == null) {
                m = m.next;
            }
            start = m;
            p = m;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        a.left = b;
        Solution s = new Solution();
        s.connect(a);

    }
}