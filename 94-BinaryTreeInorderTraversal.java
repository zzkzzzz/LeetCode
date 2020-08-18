import java.util.ArrayList;
import java.util.List;

class Solution {
    // Definition for a binary tree node.
    class TreeNode {
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

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        recrusive(root);
        return result;

    }

    private void recrusive(TreeNode root) {

        if (root != null) {
            recrusive(root.left);
            result.add(root.val);
            recrusive(root.right);
        }

    }

}

// Iterative solution
// public List<Integer> inorderTraversal(TreeNode root) {
// List<Integer> list = new ArrayList<Integer>();

// Stack<TreeNode> stack = new Stack<TreeNode>();
// TreeNode cur = root;

// while(cur!=null || !stack.empty()){
// while(cur!=null){
// stack.add(cur);
// cur = cur.left;
// }
// cur = stack.pop();
// list.add(cur.val);
// cur = cur.right;
// }

// return list;
// }
