class Solution951 {

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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        boolean left;
        boolean right;

        if (root1.left == null || root1.right == null || root2.left == null || root2.right == null) {
            if (root1.left == null && root2.left == null || root1.right == null && root2.right == null) {
                left = flipEquiv(root1.left, root2.left);
                right = flipEquiv(root1.right, root2.right);
            } else {
                left = flipEquiv(root1.left, root2.right);
                right = flipEquiv(root1.right, root2.left);
            }
        } else if (root1.left.val != root2.left.val) {
            left = flipEquiv(root1.left, root2.right);
            right = flipEquiv(root1.right, root2.left);
        } else {
            left = flipEquiv(root1.left, root2.left);
            right = flipEquiv(root1.right, root2.right);

        }

        return left && right;
    }

    public boolean flipEquiv2(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null)
            return r1 == r2;

        return r1.val == r2.val && (flipEquiv2(r1.left, r2.left) && flipEquiv2(r1.right, r2.right)
                || flipEquiv2(r1.left, r2.right) && flipEquiv2(r1.right, r2.left));
    }

}