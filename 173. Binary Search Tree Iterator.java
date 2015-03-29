public class BSTIterator {
    private Stack<TreeNode> st = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = st.pop();
        pushAllLeft(cur.right);
        return cur.val;
    }
    
    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */