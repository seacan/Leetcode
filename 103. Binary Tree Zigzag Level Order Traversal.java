public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        boolean isForward = false;
        while (level.size() != 0) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            List<Integer> pre = new ArrayList<Integer>();
                
            // process next list from last item in current list
            for (int i = level.size() - 1; i >= 0; i--) {
                TreeNode node = level.get(i);
                pre.add(0, node.val);
                if (isForward) {
                    if (node.left != null) cur.add(node.left);
                    if (node.right != null) cur.add(node.right);
                } else {
                    if (node.right != null) cur.add(node.right);
                    if (node.left != null) cur.add(node.left);       
                }
            }
            isForward = !isForward;
            res.add(pre);
            level = cur;
        }
        return res;
    }
}