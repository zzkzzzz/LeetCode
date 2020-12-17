class Solution222 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // brute force solution
    // public int countNodes(TreeNode root) {
    // if (root == null)
    // return 0;

    // int left = countNodes(root.left);
    // int right = countNodes(root.right);

    // return left + right + 1;
    // }

    // Complete binary tree
    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        // if left subtree height == right subtree height
        // then left subtree is a full binary tree
        // the nodes of left subtree will be 2^n - 1
        // and plus the root node (1) plus the right subtree nodes

        // if left subtree height is not equal to right subtree height
        // then right subtree is a full binart tree
        // then just cacualte left subtree nodes

        if (ld == rd)
            // root(1) + left full binary tree (2^n - 1) + right subtree
            // 2^n + right subtree
            return (1 << ld) + countNodes(root.right);
        else
            // root(1) + right full binary tree (2^n - 1) + left subtree
            // 2^n + left subtree
            return (1 << rd) + countNodes(root.left);

    }

    private int getDepth(TreeNode r) {
        int depth = 0;
        while (r != null) {
            depth++;
            r = r.left;
        }
        return depth;
    }
}