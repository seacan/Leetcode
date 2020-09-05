public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        boolean isForward = false;
        while (level.size() != 0) {
            List<TreeNode> next = new ArrayList<TreeNode>();
            List<Integer> cur = new ArrayList<Integer>();
                
            // process next list from last item in current list
            for (int i = level.size() - 1; i >= 0; i--) {
                TreeNode node = level.get(i);
                cur.add(0, node.val);
                if (isForward) {
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                } else {
                    if (node.right != null) next.add(node.right);
                    if (node.left != null) next.add(node.left);       
                }
            }
            isForward = !isForward;
            res.add(cur);
            level = next;
        }
        return res;
    }
}