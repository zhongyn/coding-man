import java.util.*;

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
 

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
public class SortedLinkedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            map.put(i++, head.val);
            head = head.next;            
        }
        return buildTree(map, 0, i - 1);
    }

    public TreeNode buildTree(HashMap<Integer, Integer> map, int a, int b) {
        if (a > b) {
            return null;
        }
        int m = (a + b) / 2;
        TreeNode node = new TreeNode(map.get(m));
        node.left = buildTree(map, a, m - 1);
        node.right = buildTree(map, m + 1, b);
        return node;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        SortedLinkedListToBST s = new SortedLinkedListToBST();
        TreeNode result = s.sortedListToBST(a);
        System.out.println(result.val);
    }

    private ListNode headNode;
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        return buildTree(0, n - 1);
    }

    public TreeNode buildTree(int a, int b) {
        if (a > b) {
            return null;
        }
        int m = (a + b) / 2;
        TreeNode leftNode = buildTree(a, m - 1);
        TreeNode node = new TreeNode(headNode.val);
        node.left = leftNode;
        headNode = headNode.next;
        node.right = buildTree(m + 1, b);
        return node;
    }
}