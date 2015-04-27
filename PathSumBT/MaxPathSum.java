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
    private Integer globalMax = null;
    public int maxPathSum(TreeNode root) {
        buildMax(root);
        return globalMax;
    }

    public int buildMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = buildMax(node.left);
        int rightMax = buildMax(node.right);

        int curMax = Math.max(Math.max(leftMax, rightMax), 0) + node.val;
        int passCurNodeMax = Math.max(curMax, leftMax + rightMax + node.val);
        if (globalMax == null || passCurNodeMax > globalMax) {
            globalMax = passCurNodeMax;
        } 
        return curMax;
    }
}