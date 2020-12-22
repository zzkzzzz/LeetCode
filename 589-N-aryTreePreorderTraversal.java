import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution589 {
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

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);

        for (Node child : root.children) {
            helper(child, result);
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node node : root.children)
                stack.add(node);
        }

        return list;
    }
}