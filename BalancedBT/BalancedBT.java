/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isBalanced(root.right) || !isBalanced(root.left)) {
            return false;
        }

        if (root.left == null && root.right == null) {
            root.val = 0;
        } else if (root.left == null) {
            if (root.right.val > 0) {
                return false;
            }
            root.val = root.right.val + 1;
        } else if (root.right == null) {
            if (root.left.val > 0) {
                return false;
            }
            root.val = root.left.val + 1;
        } else {
            if (Math.abs(root.right.val - root.left.val) > 1) {
                return false;
            }
            root.val = Math.max(root.right.val, root.left.val) + 1;
        }

        return true;
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isBalanced1(root.right) || !isBalanced1(root.left)) {
            return false;
        }


        if (root.left == null) {
            root.left = new TreeNode(-1);
        } 
        if (root.right == null) {
            root.right = new TreeNode(-1);
        }

        if (Math.abs(root.right.val - root.left.val) > 1) {
            return false;
        }
        root.val = Math.max(root.right.val, root.left.val) + 1;

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftStack.push(root.left);
        rightStack.push(root.right);

        TreeNode leftNode;
        TreeNode rightNode;
        while (!leftStack.empty() || !rightStack.empty()) {
            if (leftStack.empty() || rightStack.empty()) {
                return false;
            }
            leftNode = leftStack.pop();
            rightNode = rightStack.pop();
            if ((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null)) {
                return false;
            }
            if ((leftNode != null && rightNode != null) && leftNode.val != rightNode.val) {
                return false;
            }
            if (leftNode != null) {
                leftStack.push(leftNode.left);
                leftStack.push(leftNode.right);
            }
            if (rightNode != null) {
                rightStack.push(rightNode.right);
                rightStack.push(rightNode.left);               
            }
        }

        return true;

    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == rightNode;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return dfs(leftNode.left, rightNode.right) && dfs(leftNode.right, right.left);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}