public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) return res;
        String sol = Integer.toString(root.val);
        binaryTreePathsHelper(root, sol, res);
        return res;
    }
    
    private void binaryTreePathsHelper(TreeNode root, String sol,  List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(sol);
            return;
        }
        if (root.left != null) binaryTreePathsHelper(root.left, sol + "->" + root.left.val, res);
        if (root.right != null) binaryTreePathsHelper(root.right, sol + "->" + root.right.val, res);
    }
}