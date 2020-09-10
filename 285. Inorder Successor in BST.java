// Solution 1: iteration
public class Solution {
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> st = new Stack<>();
        boolean b = false;
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (b) return cur;
            if (cur == p) b = true;
            cur = cur.right;
        }
        return null;
    }
}

// Solution 2: recursion
public class Solution {
    private TreeNode pre = null, suc = null;
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) return null;
        inorder(root, p);
        return suc;
    }

    void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);
        if (pre == p) suc = root;
        pre = root;
        inorder(root.right, p);
    }
}

// Solution 3: use BST
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else root = root.right;
        }
        return res;
    }
}