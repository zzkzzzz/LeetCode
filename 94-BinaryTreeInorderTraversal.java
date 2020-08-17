import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
      
       recrusive(root);
       return result;


    }
    private void recrusive(TreeNode root) {

	 if(root!=null) {
		recrusive(root.left);
		result.add(root.val);
		recrusive(root.right);
       }

       	} 
    
}
