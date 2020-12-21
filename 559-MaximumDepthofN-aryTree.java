import java.util.List;

class Solution559 {
    public class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    int max = 0;

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        helper(root, 1);
        return max + 1;
    }

    private void helper(Node root, int level) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            if (level > max) {
                max = level;
            }

            helper(child, level + 1);
        }

    }
}