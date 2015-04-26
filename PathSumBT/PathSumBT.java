import java.util.*;
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class PathSumBT {
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> list = new LinkedList<>();
            list.add(0, root.val);
            List<List<Integer>> lol = new LinkedList<>();
            lol.add(list);
            return lol;
        }
        
        List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightList = pathSum(root.right, sum - root.val);
        List<List<Integer>> rootList = new LinkedList<>();

        if (leftList.size() > 0) {
            for (List<Integer> n : leftList) {
                n.add(0, root.val);
            }
            rootList = leftList;
        }

        if (rightList.size() > 0) {
            for (List<Integer> n : rightList) {
                n.add(0, root.val);
            }
            if (rootList != null) {
                rootList.addAll(rightList);
            } else {
                rootList = rightList;
            }
        }

        return rootList;
    }    

    public static void main(String[] args) {
        System.out.println("abc");
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        PathSumBT ps = new PathSumBT();
        System.out.println(ps.pathSum(null, 3));
    }
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
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
        return 1;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // public int minDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return minDFS(root);
    // }

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


}