public class Solution {
    public int findDiameter(TreeNode root) {
        int[] diameter = new int[]{0};
        calculateHight(root, diameter);
        return diameter[0];
    }

    private int calculateHight(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        int left = calculateHight(node.left, diameter);
        int right = calculateHight(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
}
