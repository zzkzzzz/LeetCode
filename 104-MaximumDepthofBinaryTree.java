
class Solution104 {
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

    int max = 0;

    public int maxDepth(TreeNode root) {
        findDepth(root, 0);
        return max;
    }

    private void findDepth(TreeNode root, int depth) {
        max = Math.max(max, depth);

        if (root == null)
            return;

        findDepth(root.left, depth + 1);
        findDepth(root.right, depth + 1);
    }
}