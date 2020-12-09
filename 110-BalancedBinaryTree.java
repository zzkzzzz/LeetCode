class Solution110 {
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

    // balanced binary tree:
    // difference between the heights of the two sub trees are not bigger than 1
    // and both the left sub tree and right sub tree are also balanced
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // postorder traverse
        int left = helper(root.left);
        int right = helper(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

}