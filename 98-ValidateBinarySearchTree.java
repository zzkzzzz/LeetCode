class Solution98 {
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

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null)
            return true;

        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}