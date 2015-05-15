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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode base = new TreeNode(0);
        base.right = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(base);
        LinkedList<Integer> result = new LinkedList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                TreeNode tmp = node.right;
                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }
        }

        result.removeFirst();
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode base = new TreeNode(0);
        base.right = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(base);
        List<Integer> result = new LinkedList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                TreeNode tmp = node.right;
                while (tmp != null) {
                    stack.push(tmp);
                    result.add(tmp.val);
                    tmp = tmp.left;
                }
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}