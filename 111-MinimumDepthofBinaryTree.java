import java.util.LinkedList;
import java.util.Queue;

class Solution111 {

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

    // postorder
    // DFS
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }

    // BFS ->level order traverse
    // better solution
    // If you have a tree where say the root's left subtree has a depth of 500 and
    // the right subtree has a depth of 1, the code is going to traverse all the way
    // down the 500 left subtree first before finally traversing the right subtree
    // with a measly depth of 1 and figuring out "d'oh!" that's the min depth.

    // With BFS, instead of traversing 501 nodes to figure out the min depth, you
    // could've just traversed two. Now imagine if the left subtree comprised of
    // tens of thousands of nodes ...

    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr != null) {
                    // find out the minimum depth
                    if (curr.left == null && curr.right == null)
                        return depth;
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
}