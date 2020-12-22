class Solution606 {

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

    String result = "";

    public String tree2str(TreeNode t) {

        if (t == null)
            return "";

        result = result + t.val + "";

        if (t.right != null) {
            result = result + ("(");
            tree2str(t.left);
            result = result + (")");

            result = result + ("(");
            tree2str(t.right);
            result = result + (")");
        } else if (t.left != null) {
            result = result + ("(");
            tree2str(t.left);
            result = result + (")");
        }

        return result;
    }

    public String tree2str2(TreeNode t) {
        if (t == null)
            return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "")
            return result;
        if (left == "")
            return result + "()" + "(" + right + ")";
        if (right == "")
            return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}