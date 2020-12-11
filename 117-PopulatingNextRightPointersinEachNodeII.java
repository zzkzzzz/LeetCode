class Solution117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // similar to problem 116
    // added few conditions and helper function to find next node
    public Node connect(Node root) {
        if (root == null)
            return null;

        if (root.left != null) {
            if (root.right != null)
                root.left.next = root.right;
            else
                root.left.next = fnext(root.next);
        }

        if (root.right != null)
            root.right.next = fnext(root.next);

        connect(root.right);
        connect(root.left);

        return root;
    }

    Node fnext(Node root) {
        if (root == null)
            return null;

        if (root.left != null)
            return root.left;

        if (root.right != null)
            return root.right;

        return fnext(root.next);
    }

    // cnm
    // public void connect2(Node root) {
    // Node tempChild = new Node(0);

    // while (root != null) {
    // Node currentChild = tempChild;

    // while (root != null) {

    // if (root.left != null) {
    // currentChild.next = root.left;
    // currentChild = currentChild.next;
    // }
    // if (root.right != null) {
    // currentChild.next = root.right;
    // currentChild = currentChild.next;
    // }
    // root = root.next;
    // }

    // root = tempChild.next;
    // tempChild.next = null;
    // }
    // }
}