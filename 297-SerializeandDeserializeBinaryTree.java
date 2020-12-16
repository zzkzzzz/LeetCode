import java.util.LinkedList;

class Solution100 {

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

    // Encodes a tree to a single string.
    String SEP = ",";
    String NULL = "null";

    /* 主函数，将二叉树序列化为字符串 */
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /****** pre order traversal ******/
        sb.append(root.val).append(SEP);
        /***********************/

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;

        /****** pre order traversal ******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize2(root.left, sb);
        serialize2(root.right, sb);

        /****** post order traversal ******/
        sb.append(root.val).append(SEP);
        /***********************/
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode deserialize2(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize2(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize2(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;
        // 从后往前取出元素
        String last = nodes.removeLast();
        if (last.equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 限构造右子树，后构造左子树
        root.right = deserialize2(nodes);
        root.left = deserialize2(nodes);

        return root;
    }
}
