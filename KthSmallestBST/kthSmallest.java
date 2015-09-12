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
    public int findKthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int result = 0;
        
        for (int i = 0; i < k; i++) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result = node.val;
            node = node.right;
        }
        return result;
    }

    public int findKthSmallest(TreeNode root, int k) {
        
    }
}