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
        if (node.left == null && pre == null) {
            pre = node;
            return;
        }
        if (node.val < pre.val) {
            if (one == null) {
                one = pre;
            }
            two = node;
        }
        pre = node;
        dfs(node.right);
    }
}