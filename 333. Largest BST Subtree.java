class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) return count(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isValid(TreeNode root, int mn, int mx) {
        if (root == null) return true;
        if (root.val <= mn || root.val >= mx) return false;
        return isValid(root.left, mn, root.val) && isValid(root.right, root.val, mx);
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}