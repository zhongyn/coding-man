import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) {val = v;}
}

class BST2Sum {
    public List<TreeNode> twoSum(TreeNode root, int target) {
        List<TreeNode> res = new ArrayList<>(2);
        BSTIterator in = new BSTInorder(root);
        BSTIterator re = new BSTReverse(root);
        TreeNode lo = in.hasNext() ? in.next() : null;
        TreeNode hi = re.hasNext() ? re.next() : null;

        while (lo != null && hi != null && lo.val < hi.val) {
            int sum = lo.val + hi.val;
            if (sum == target) {
                res.add(lo);
                res.add(hi);
                break;
            } else if (sum < target) {
                lo = in.hasNext() ? in.next() : null;
            } else {
                hi = re.hasNext() ? re.next() : null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BST2Sum so = new BST2Sum();
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        List<TreeNode> res = so.twoSum(a, 2);
        System.out.println(res);
    }
}

abstract class BSTIterator {
    Deque<TreeNode> stack = new LinkedList<>();

    abstract void addNode(TreeNode node);

    public abstract TreeNode next();

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class BSTInorder extends BSTIterator {

    public BSTInorder(TreeNode root) {
        addNode(root);
    }

    void addNode(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public TreeNode next() {
        TreeNode node = stack.pop();
        addNode(node.right);
        return node;
    }
}

class BSTReverse extends BSTIterator {
    public BSTReverse(TreeNode root) {
        addNode(root);
    }

    void addNode(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    public TreeNode next() {
        TreeNode node = stack.pop();
        addNode(node.left);
        return node;        
    }
}

