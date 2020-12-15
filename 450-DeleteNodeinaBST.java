
class Solution450 {

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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {

            // if the node only have one child
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            TreeNode rightSmallest = root.right;
            TreeNode rightSmallestParent = null;

            while (rightSmallest.left != null) {
                rightSmallestParent = rightSmallest;
                rightSmallest = rightSmallest.left;
            }

            if (rightSmallestParent == null) {
                rightSmallest.left = root.left;
                return rightSmallest;
            }

            rightSmallestParent.left = rightSmallest.right;
            rightSmallest.left = root.left;
            rightSmallest.right = root.right;

            return rightSmallest;

        } else if (root.val > key) {
            // search in left subtree
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // search in right subtree
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode2(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode2(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode2(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}