class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ValidateBT {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidChild(root).valid;
    }

    public Node isValidChild(TreeNode root) {
        if (root == null) {
            return null;
        }

        Node leftChild = isValidChild(root.left);
        Node rightChild = isValidChild(root.right);

        if (leftChild == null && rightChild == null) {
            return new Node(true, root.val, root.val);
        }

        if (leftChild == null) {
            if (rightChild.valid && root.val < rightChild.min) {
                rightChild.min = root.val;
            } else {
                rightChild.valid = false;
            }
            return rightChild;
        }
        if (rightChild == null) {
            if (leftChild.valid && root.val > leftChild.max) {
                leftChild.min = root.val;
            } else {
                leftChild.valid = false;
            }
            return leftChild;
        }

        if (leftChild.valid && rightChild.valid && leftChild.max < root.val && root.val < rightChild.min) {
            leftChild.max = rightChild.max;
        } else {
            leftChild.valid = false;
        }
        return leftChild;
    }

    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isIncreasing(root);
    }
    public boolean isIncreasing(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isIncreasing(root.left)) {
            if (prev != null && root.val < prev.val) {
                return false;
            }
            prev = root;
            return isIncreasing(root.right);
        } 
        return false;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;

        ValidateBT bt = new ValidateBT();
        System.out.println(bt.isValidBST(a));
    }
}

class Node {
    boolean valid;
    int max;
    int min;

    public Node (boolean v, int ma, int mi) {
        valid = v;
        max = ma;
        min = mi;
    }

}