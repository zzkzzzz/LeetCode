/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution114 {
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

    void flatten(TreeNode root) {
        // base case
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        /**** Post order traversal ****/
        // 1. left and right of root already flatten to a line
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2. set the right of root to left
        root.left = null;
        root.right = left;

        // 3. connect the pre right to the end
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}