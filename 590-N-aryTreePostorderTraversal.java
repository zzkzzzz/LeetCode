import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

class Solution590 {
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

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            helper(child, result);
        }

        result.add(root.val);
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node node : root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}