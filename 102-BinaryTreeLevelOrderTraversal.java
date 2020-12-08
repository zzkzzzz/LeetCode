import java.util.List;
import java.util.LinkedList;

class Solution102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, root, 0);
        return result;

    }

    private void helper(List<List<Integer>> result, TreeNode node, int level) {
        // preorder traverse
        if (node == null)
            return;
        if (level == result.size())
            result.add(new LinkedList<>());

        result.get(level).add(node.val);
        helper(result, node.left, level + 1);
        helper(result, node.right, level + 1);
    }
}