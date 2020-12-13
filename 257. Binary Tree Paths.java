// Path to the leaf node
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) return res;        
        binaryTreePathsHelper(root, "", res);
        return res;
    }
    
    private void binaryTreePathsHelper(TreeNode root, String sol,  List<String> res) {
        if (root == null) return;
        sol = sol.isEmpty() ? Integer.toString(root.val) : sol + "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(sol);
            return;
        }
        binaryTreePathsHelper(root.left, sol, res);
        binaryTreePathsHelper(root.right, sol, res);
    }
}