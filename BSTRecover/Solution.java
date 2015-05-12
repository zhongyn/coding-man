/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode one;
    private TreeNode two;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre != null && node.val < pre.val) {
            if (one == null) {
                one = pre;
            }
            two = node;
        }
        pre = node;
        dfs(node.right);
    }

    public void recoverTree(TreeNode root) {
        TreeNode one = null;
        TreeNode two = null;
        TreeNode pre = null;

        TreeNode cur = root;
        TreeNode tmp = null;

        while (cur != null) {
            if (cur.left == null) {
                if (pre != null && cur.val < pre.val) {
                    if (one == null) {
                        one = pre;
                    }
                    two = cur;
                }
                pre = cur;
                cur = cur.right;
            } else {
                tmp = cur.left;
                while (tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }

                if (tmp.right == null) {
                    tmp.right = cur;
                    cur = cur.left;
                } else {
                    tmp.right = null;
                    if (cur.val < pre.val) {
                        if (one == null) {
                            one = pre;
                        }
                        two = cur;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }

        int v = one.val;
        one.val = two.val;
        two.val = v;
    }
}