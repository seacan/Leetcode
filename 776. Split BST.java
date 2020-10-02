// Input: root = [4,2,6,1,3,5,7], V = 2
// Output: [[2,1],[4,3,6,null,null,5,7]]
class Solution {
    public static TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) return res;
        if (root.val <= V) {
            res = splitBST(root.right, V);
            root.right = res[0];
            res[0] = root;
        } else {
            res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }
}