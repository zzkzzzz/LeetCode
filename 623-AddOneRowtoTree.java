class Solution623 {
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

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {
            TreeNode result = new TreeNode(v);
            result.left = root;
            return result;
        }
        helper(root, v, d, 2);

        return root;

    }

    private void helper(TreeNode root, int v, int d, int level) {
        if (root == null)
            return;

        if (level == d) {
            TreeNode left = root.left;
            root.left = new TreeNode(v);
            root.left.left = left;

            TreeNode right = root.right;
            root.right = new TreeNode(v);
            root.right.right = right;

        }

        helper(root.left, v, d, level + 1);
        helper(root.right, v, d, level + 1);

    }

}