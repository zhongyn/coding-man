// largest differece of a node and its ancestor node
// corner cases: overflow, null root, one node

public class BTDiff {
    private long result = Long.MIN_VALUE;

    public int largestDiff(TreeNode root) {
        if (root == null || (root.left == null && root.right == null) {
            return 0;
        }
        dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.right == null) {
            int left = dfs(root.left);
            long diff = root.val - left;
            result = result < diff ? diff : result;
            return left;
        }
        if (root.left == null) {
            int right = dfs(root.right);
            long diff = root.val - right;
            result = result < diff ? diff : result;
            return right;            
        }
    }
}