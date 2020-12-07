import java.util.Deque;
import java.util.LinkedList;

class Solution654 {

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

    // time complexity=O(nlogn)
    // worst time complexity=O(n^2)
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // find max number and its index
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        // recursively build the tree
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }

    // time complexity=O(n)
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            // if the head of the stack is less than curr
            // then just set the head as left child of curr
            // bcs the elements inside the stack are all at left side of curr
            // then the stack will be empty after this
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            // if the head of the stack is larger than curr
            // just attach the curr to right child of the head
            // bcs curr is at right side of the head
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}