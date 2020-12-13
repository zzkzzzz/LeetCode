import java.util.HashMap;
import java.util.Map;

class Solution437 {

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

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    public int pathSum(TreeNode root, int sum) {
        // using HashMap to store
        // key : the prefix sum,
        // value : how many ways get to this prefix sum
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        // check if currSum - target exists in hashmap or not, if it does, we added
        // up the ways of prefix sum - target into res.
        int res = preSum.getOrDefault(currSum - target, 0);

        // update the prefix sum map
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        int left = helper(root.left, currSum, target, preSum);
        int right = helper(root.right, currSum, target, preSum);

        res += left + right;

        // backtrack
        // bcs the map will pass to other subtrees, current sum used current node should
        // be removed from map
        preSum.put(currSum, preSum.get(currSum) - 1);

        return res;
    }

    // brute force solution
    // Space Complexity: O(n) due to recursion.
    // Time Complexity: O(n^2) in worst case (no branching);
    // O(nlogn) in best case (balanced tree).

    public int pathSum2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }
}