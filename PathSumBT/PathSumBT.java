/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode node, int pre, int sum) {
        if (node == null) {
            return false;
        }
        int cur = pre + node.val;

        if (cur == sum && node.left == null && node.right == null) {
            return true;
        }
        return dfs(node.left, cur, sum) || dfs(node.right, cur, sum);
    }

    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null)
        int d = 0;

        TreeNode a, b;
        while (q.size() > 1) {
            a = q.remove();
            b = q.element();
            if (a != null) {
                if (a.left == null && a.right == null) {
                    return d;
                }
                if (a.left != null) {
                    q.add(a.left);
                }
                if (a.right != null) {
                    q.add(a.right);
                }
                if (b == null) {
                    q.add(null);
                    d++;
                }
            }
        }
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDFS(root);
    }

    public int minDFS(TreeNode root) {
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left != null) {
            return minDepth(root.left) + 1;
        }
        if (root.right != null) {
            return minDepth(root.right) + 1;
        }
        return 1;        
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}