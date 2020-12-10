class Solution122 {
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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (sum == root.val && root.left == null && root.right == null)
            return true;

        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);

        return left || right;
    }

}