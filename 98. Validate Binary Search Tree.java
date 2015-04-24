// solution 1: in order traverse
public class Solution {
    private TreeNode last = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (last != null && last.val >= root.val) return false;
        last = root;
        if (!isValidBST(root.right)) return false;
        return true;
    }
}


// solution 2: with min max value for each node
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
    
    private boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && min >= root.val) || (max != null && root.val >= max)) return false;
        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }
}