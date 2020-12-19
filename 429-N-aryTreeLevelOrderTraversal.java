import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution429 {
    // Definition for a Node.
    class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null)
            return ret;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }

    // recursive solution
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null)
            return ret;

        dfs(root, ret, 0);

        return ret;
    }

    private List<List<Integer>> dfs(Node node, List<List<Integer>> res, int level) {
        if (node == null)
            return res;
        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(node.val);

        for (Node child : node.children)
            dfs(child, res, level + 1);

        return res;
    }
}