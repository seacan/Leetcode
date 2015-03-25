public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while (level.size() != 0) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            List<Integer> pre = new ArrayList<Integer>();
            for (TreeNode node : level) {
                pre.add(node.val);
                if (node.left != null) cur.add(node.left);
                if (node.right != null) cur.add(node.right);
            }
            res.add(pre);
            level = cur;
        }
        return res;
    }
}