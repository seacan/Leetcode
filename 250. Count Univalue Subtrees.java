// Given a binary tree, count the number of uni-value subtrees.
// A Uni-value subtree means all nodes of the subtree have the same value.
// Input:  root = [5,1,5,5,5,null,5]
// Output: 4
public class Solution {
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root, -1);
        return res;
    }

    public boolean isUnival(TreeNode root, int val) {
        if (root == null) return true;
        if (!isUnival(root.left, root.val) | !isUnival(root.right, root.val)) {
            return false;
        }
        res++;
        return root.val == val;
    }
}