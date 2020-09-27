public class Solution {
    int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) <= Math.abs(res - target))
                res = root.val;            
            root = target < root.val ? root.left : root.right;
        }
        return res;
    }

public class Solution {
    int closestValue(TreeNode root, double target) {
        int cur = root.val;
        TreeNode t = target < cur ? root.left : root.right;
        if (t == null) return cur;
        int next = closestValue(t, target);
        return Math.abs(cur - target) < Math.abs(next - target) ? cur : next;
    }
}