public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        int total = 0;
        if (root.left != null)
            total += sumNumbersHelper(root.left, sum * 10 + root.val);
        if (root.right != null)
            total += sumNumbersHelper(root.right, sum * 10 + root.val);
        return total;
    }
}