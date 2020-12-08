import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

class Solution652 {

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

    // record the frequency of subtrees serials
    // eliminate duplicate results
    HashMap<String, Integer> memo = new HashMap<>();
    // record result
    LinkedList<TreeNode> res = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        // postorder traverse
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // add to result list only when it repeat once
        if (freq == 1) {
            res.add(root);
        }
        // add the frequency of the serial
        memo.put(subTree, freq + 1);
        return subTree;
    }
}