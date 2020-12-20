import java.util.List;
import java.util.ArrayList;

class Solution515 {

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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return;

        if (result.size() <= level) {
            result.add(root.val);
        }

        if (result.get(level) < root.val) {
            result.set(level, root.val);
        }

        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);

    }
}