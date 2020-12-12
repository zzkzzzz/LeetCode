import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution144 {

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

    List<Integer> result;

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new LinkedList<>();
        helper(root);
        return result;
    }

    private void helper(TreeNode node) {
        if (node == null)
            return;
        result.add(node.val);

        helper(node.left);
        helper(node.right);
    }

    // Iterative
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                list.add(p.val); // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return list;
    }
}