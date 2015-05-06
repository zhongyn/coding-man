
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatSubTree(root);
    }

    public TreeNode flatSubTree (TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            return flatSubTree(root.right);
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return flatSubTree(root.right);
        }
        TreeNode leftTail = flatSubTree(root.left);
        TreeNode rightTail = flatSubTree(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        leftTail.right = tmp;
        return rightTail;
    }

    TreeNode base = new TreeNode(0);
    TreeNode tail = base;
    public void flatten(TreeNode root) {
        dfs(root);
        while (root != null) {
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        tail.left = root;
        tail = root;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(8);
        TreeNode j = new TreeNode(9);
        TreeNode k = new TreeNode(10);
        TreeNode l = new TreeNode(11);
        TreeNode m = new TreeNode(12);
        TreeNode n = new TreeNode(13);

        a.left = b;
        b.left = c;
        a.right = d;
        d.left = e;
        d.right = f;
        f.left = g;
        f.right = h;
        g.left = i;
        g.right = j;
        h.left = k;
        h.right = l;
        l.left = m;
        m.right = n;

        Solution so = new Solution();
        so.flatten(a);
        // while (a != null) {
        //     System.out.println(a.val);
        //     a = a.right;
        // }

    }
}