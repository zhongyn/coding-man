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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> nums = dfs(root, 0);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    public List<Integer> dfs(TreeNode node, int n) {
        List<Integer> ls = new ArrayList<>();
        int cur = n * 10 + node.val;
        if (node.left == null && node.right == null) {
            ls.add(cur);
            return ls;
        }
        if (node.left != null) {
            ls.addAll(dfs(node.left, cur));
        }
        if (node.right != null) {
            ls.addAll(dfs(node.right, cur));
        }
        return ls;
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int n) {
        if (root == null) {
            return 0;
        }
        int cur = n * 10 + node.val;
        if (node.left == null && node.right == null) {
            return cur;
        }
        return dfs(node.left, cur) + dfs(node.right, cur);
    }

}