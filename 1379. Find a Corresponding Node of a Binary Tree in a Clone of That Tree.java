// Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
// Output: 4
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) return cloned;
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null) return res;
        return getTargetCopy(original.right, cloned.right, target);
    }
}