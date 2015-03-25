public class Solution {
    public void recoverTree(TreeNode root) {
        recoverTreeHelper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private TreeNode last = null, first = null, second = null;
    private void recoverTreeHelper(TreeNode root) {
        if (root == null) return;
        recoverTreeHelper(root.left);
        if (last != null && first == null && last.val >= root.val)
            first = last;
        if (last != null && first != null && last.val >= root.val) // don't need to consider second==null
            second = root; // second will be root
        last = root;
        recoverTreeHelper(root.right);
    }
}