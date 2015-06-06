
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int countNodes1(TreeNode root) {
        int h = -1;
        int sum = 0;
        TreeNode tmp = root;
        while (tmp != null) {
            h++;
            sum += 1 << h;
            tmp = tmp.left;
        }
        if (h < 0) {
            return sum;
        }
        sum -= 1 << h;
        System.out.println(sum);

        int last = 0;
        while (root != null) {
            int lh = 0;
            int rh = 0;
            TreeNode ln = root.left;
            TreeNode rn = root.right;
            while (ln != null) {
                lh++;
                ln = ln.right;
            }
            while (rn != null) {
                rh++;
                rn = rn.left;
            }

            if (lh == h && rh == h) {
                root = root.right;
                last += 1 << (h - 1);
            } else if (lh < h && rh < h) {
                root = root.left;
            } else {
                last += 1 << (h - 1);
                break;
            }
            h--;
        }
        return sum + last;
    }

    public int countNodes(TreeNode root) {
        int sum = 0;

        while (root != null) {
            int llh = leftDepth(root.left);
            int lrh = rightDepth(root.left);
            int rlh = leftDepth(root.right);
            int rrh = rightDepth(root.right);
            if (llh == rrh) {
                sum += (1 << llh + 1) - 1;
                break;
            } else if (llh > lrh) {
                sum += 1 << rrh;
                root = root.left;
            } else {
                sum += 1 << llh;
                root = root.right;
            }
        }
        return sum;
    }

    public int leftDepth(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }

    public int rightDepth(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.right;
            h++;
        }
        return h;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        Solution so = new Solution();
        System.out.println(so.countNodes(a));
    }
}