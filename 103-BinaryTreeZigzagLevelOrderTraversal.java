import java.util.List;
import java.util.LinkedList;

class Solution103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, root, 0, false);
        return result;

    }

    private void helper(List<List<Integer>> result, TreeNode node, int level, boolean reverse) {
        // preorder traverse
        if (node == null)
            return;
        if (level == result.size())
            result.add(new LinkedList<>());

        if (!reverse)
            result.get(level).add(node.val);
        else
            result.get(level).add(0, node.val);

        helper(result, node.left, level + 1, !reverse);
        helper(result, node.right, level + 1, !reverse);

    }
}