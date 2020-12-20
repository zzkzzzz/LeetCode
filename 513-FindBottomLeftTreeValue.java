class Solution513 {

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

    int max = 1;
    int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        helper(1, root);
        return value;
    }

    private void helper(int level, TreeNode root) {
        if (root == null)
            return;

        helper(level + 1, root.left);
        helper(level + 1, root.right);

        if (level > max) {
            max = level;
            value = root.val;
        }

    }

}