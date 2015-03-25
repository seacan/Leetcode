public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b != null && a.val == b.val)
            return isSame(a.left, b.right) && isSame(a.right, b.left);
        return false;
    }
}