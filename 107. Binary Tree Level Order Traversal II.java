public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while (level.size() != 0) {
            List<TreeNode> next = new ArrayList<TreeNode>();
            List<Integer> cur = new ArrayList<Integer>();
            for (TreeNode node : level) {
                cur.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            res.add(0, cur);
            level = next;
        }
        return res;
    }
}