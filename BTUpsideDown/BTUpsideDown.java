class BTUpsideDown {
    private TreeNode newRoot;
    public TreeNode upsideDown(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root);
        
        
    }
    public TreeNode dfs(TreeNode node) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null && root.right != null) {
            root.left = root.right;
            return root;
        }

        TreeNode n = dfs(n.left);
        node.left.left = node.right;
        node.left.right = node;
        return n;
    }
}