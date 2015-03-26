public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // check leaf node
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}