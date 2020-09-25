public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int sum) {
        // test case [0, 1]
        if (root == null) return 0;
        sum = 10 * sum + root.value;
        // handle leaf node
        if (root.left == null && root.right == null)
            return sum;
        return sumNumbersHelper(root.left, sum) + sumNumbersHelper(root.right, sum);
    }
}