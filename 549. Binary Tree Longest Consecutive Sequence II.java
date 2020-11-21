class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int res = helper(root, 1) + helper(root, -1) - 1;
        return Math.max(res, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }

    private int helper(TreeNode node, int diff) {
        if (node == null) return 0;
        int left = 0, right = 0;
        if (node.left != null && node.val - node.left.val == diff)
            left = 1 + helper(node.left, diff);
        if (node.right != null && node.val - node.right.val == diff)
            right = 1 + helper(node.right, diff);
        return Math.max(left, right);
    }
}