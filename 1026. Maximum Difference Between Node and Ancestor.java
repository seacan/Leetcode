// Input: [8,3,10,1,6,null,14,null,null,4,7,13]
// Output: 7
// Explanation: Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
}