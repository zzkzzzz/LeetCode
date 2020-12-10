import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution113 {

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        backtrack(root, sum, result, new ArrayList<>(Arrays.asList(root.val)));
        return result;
    }

    public void backtrack(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp) {

        if (sum == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(temp));
        }

        if (root.left != null) {
            temp.add(root.left.val);
            backtrack(root.left, sum - root.val, result, temp);
            temp.remove(temp.size() - 1);
        }

        if (root.right != null) {
            temp.add(root.right.val);
            backtrack(root.right, sum - root.val, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}