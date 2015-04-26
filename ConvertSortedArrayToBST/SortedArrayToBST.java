/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        return buildTree(num, 0, num.length - 1);
    }

    public TreeNode buildTree(int[] A, int a, int b) {
        if (a > b) {
            return null;
        }
        int m = (a + b) / 2;
        TreeNode node = new TreeNode(A[m]);
        node.left = buildTree(A, a, m - 1);
        node.right = buildTree(A, m + 1, b);
        return node;
    }
}