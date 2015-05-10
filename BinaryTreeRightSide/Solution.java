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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);
        frontier.add(null);
        List<Integer> righSide = new ArrayList<>();

        while (frontier.size() > 1) {
            TreeNode cur = frontier.remove();
            TreeNode next = frontier.element();

            if (cur != null) {
                if (cur.left != null) {
                    frontier.add(cur.left);
                }
                if (cur.right != null) {
                    frontier.add(cur.right);
                }
                if (next == null) {
                    righSide.add(cur.val);
                    frontier.add(null);
                }
            }
        }
        return righSide;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);
        frontier.add(null);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> level = new LinkedList<>();

        boolean leftToRight = true;

        while (frontier.size() > 1) {
            TreeNode cur = frontier.remove();
            TreeNode next = frontier.element();

            if (cur != null) {
                if (leftToRight) {
                    level.add(cur.val);
                } else {
                    level.addFirst(cur.val);
                }
                if (cur.left != null) {
                    frontier.add(cur.left);
                }
                if (cur.right != null) {
                    frontier.add(cur.right);
                }
                if (next == null) {
                    frontier.add(null);
                    result.add(level);
                    level = new LinkedList<>();
                    leftToRight = !leftToRight;
                }
            }
        }
        return result;        
    }
}