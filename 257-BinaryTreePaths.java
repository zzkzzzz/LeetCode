import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution257 {

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

    String SEP = "->";

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        helper(result, root, new ArrayList<>(Arrays.asList(root.val)));
        return result;
    }

    private void helper(List<String> result, TreeNode root, ArrayList<Integer> temp) {
        if (root.left == null && root.right == null) {
            result.add(temp.stream().map(x -> x.toString()).collect(Collectors.joining("->")));
            return;
        }

        if (root.left != null) {
            temp.add(root.left.val);
            helper(result, root.left, temp);
            temp.remove(temp.size() - 1);
        }

        if (root.right != null) {
            temp.add(root.right.val);
            helper(result, root.right, temp);
            temp.remove(temp.size() - 1);
        }

    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null)
            searchBT(root, "", answer);
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null)
            answer.add(path + root.val);
        if (root.left != null)
            searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null)
            searchBT(root.right, path + root.val + "->", answer);
    }

}