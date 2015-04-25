/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> level = new LinkedList<Integer>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        q.add(root);
        q.add(null);

        TreeNode a, b;
        while (q.size() > 1) {
            a = q.remove();
            b = q.element();
            if (a != null) {
                level.add(a.val);
                if (a.left != null) {
                    q.add(a.left);
                }
                if (a.right != null) {
                    q.add(a.right);
                }
                if (b == null) {
                    q.add(null);
                    result.add(level);
                    level = new LinkedList<Integer>();
                }
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, root, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new LinkedList<Integer>());
        }
        result.get(level).add(node.val);
        dfs(result, node.left, level + 1);
        dfs(result, node.right, level + 1);
    }
}