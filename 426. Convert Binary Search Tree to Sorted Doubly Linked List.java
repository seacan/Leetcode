// Solution 1: in-order recursive traverse
class Solution {
    TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode head = null, tail = null;
        inorder(root, head, tail);
        tail.right = head;
        head.left = tail;
        return head;
    }

    void inorder(TreeNode node, TreeNode head, TreeNode tail) {
        if (node == null) return;
        inorder(node.left, head, tail);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }
        inorder(node.right, head, tail);
    }
}


// Solution 2: in-order iterative traverse
class Solution {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode head = null, tail = null;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (head == null) head = root;
            if (tail != null) {
                tail.right = root;
                root.left = tail;
            }
            tail = root;
            root = root.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }
}


// Solution 3: link head and tail during the recursion
class Solution {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode leftHead = treeToDoublyList(root.left);
        TreeNode rightHead = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return connect(connect(leftHead, root), rightHead);
    }

    private TreeNode connect(TreeNode node1, TreeNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        TreeNode tail1 = node1.left, tail2 = node2.left;
        tail1.right = node2;
        node2.left = tail1;
        tail2.right = node1;
        node1.left = tail2;
        return node1;
    }
}