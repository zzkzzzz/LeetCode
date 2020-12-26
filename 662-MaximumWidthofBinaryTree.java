import java.util.List;
import java.util.ArrayList;

class Solution662 {
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

    public int widthOfBinaryTree(TreeNode root) {
        // arraylist record the left most index of this level
        // root: i
        // left: i * 2 right: i * 2 + 1
        helper(root, new ArrayList<>(), 0, 0);
        return max;
    }

    void helper(TreeNode root, List<Integer> lefts, int level, int index) {
        if (root == null)
            return;
        if (level == lefts.size()) {
            lefts.add(index);
        }
        max = Math.max(max, index - lefts.get(level) + 1);
        helper(root.left, lefts, level + 1, index * 2);
        helper(root.right, lefts, level + 1, index * 2 + 1);
    }
}