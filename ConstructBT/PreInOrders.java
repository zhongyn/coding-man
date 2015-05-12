import java.util.*;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PreInOrders {

    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    // }

    // public TreeNode build(int a, int b, int m, int n, int[] pre, int[] in) {
    //     if (a > b) {
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(pre[a]);
    //     int id = m;
    //     while (id <= n && in[id] != pre[a]) {
    //         id++;
    //     }
    //     int numLeft = id - m;
    //     root.left = build(a + 1, a + numLeft, m, id - 1, pre, in);
    //     root.right = build(a + numLeft + 1, b, id + 1, n, pre, in);
    //     return root;
    // }

    // Post-order and In-order
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(0, postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }

    public TreeNode build(int a, int b, int m, int n, int[] post, int[] in) {
        if (a > b) {
            return null;
        }
        TreeNode root = new TreeNode(post[b]);
        int id = m;
        while (id <= n && in[id] != post[b]) {
            id++;
        }
        int numLeft = id - m;
        root.left = build(a, a + numLeft - 1, m, id - 1, post, in);
        root.right = build(a + numLeft, b - 1, id + 1, n, post, in);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {0,1,2};
        int[] preorder = {0,1,2};
        PreInOrders so = new PreInOrders();
        TreeNode root = so.buildTree(preorder, inorder);
        // TreeNode root = so.buildTree(new int[]{}, new int[]{});
        System.out.println(root.val);
    }
}