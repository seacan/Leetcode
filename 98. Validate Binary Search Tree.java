public class Solution {
    private TreeNode last = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && !isValidBST(root.left)) return false;
        if (last != null && last.val >= root.val) return false;
        last = root;
        if (root.right != null && !isValidBST(root.right)) return false;
        return true;
    }
}