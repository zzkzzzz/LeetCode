class Solution129 {

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

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, "");
    }

    private int helper(TreeNode root, String num) {

        if (root == null)
            return 0;

        // pre traverse
        // string concat is a bit slow
        if (root.left == null && root.right == null)
            return Integer.valueOf(num + root.val);

        int left = helper(root.left, num + root.val);
        int right = helper(root.right, num + root.val);

        return left + right;
    }

    public int sumNumbers2(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s) {
        if (n == null)
            return 0;

        if (n.right == null && n.left == null)
            return s * 10 + n.val;

        // pre traverse
        int left = sum(n.left, s * 10 + n.val);
        int right = sum(n.right, s * 10 + n.val);

        return left + right;
    }

}