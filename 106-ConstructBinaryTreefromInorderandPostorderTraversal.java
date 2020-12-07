
class Solution106 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {

        if (postStart > postEnd) {
            return null;
        }

        // current root is the start node of postorder array
        int rootVal = postorder[postEnd];

        // find the index of current root in inorder array
        // can use hashmap to cache the location of the nodes
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        // recursively build the left subtree and right subtree
        root.left = build(postorder, postStart, postStart + leftSize - 1, inorder, inStart, index - 1);
        root.right = build(postorder, postStart + leftSize, postEnd - 1, inorder, index + 1, inEnd);

        return root;
    }
}