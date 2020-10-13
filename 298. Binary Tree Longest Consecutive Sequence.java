// Input:
// 
//    1
//     \
//      3
//     / \
//    2   4
//         \
//          5
// 
// Output: 3
// Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
class Solution {
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int len) {
        res = Math.max(res, len);
        if (root.left != null) {
            if (root.left.val == root.val + 1) dfs(root.left, len + 1);
            else dfs(root.left, 1);
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) dfs(root.right, len + 1);
            else dfs(root.right, 1);
        }
    }
}

class Solution {
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    int helper(TreeNode root, TreeNode p, int res) {
        if (root == null) return res;
        res = (p != null && root.val == p.val + 1) ? res + 1 : 1;
        return Math.max(res, Math.max(helper(root.left, root, res), helper(root.right, root, res)));
    }
}