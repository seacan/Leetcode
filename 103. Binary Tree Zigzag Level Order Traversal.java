public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        boolean isForward = false;
        while (level.size() != 0) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            List<Integer> curValue = new ArrayList<Integer>();
            // pre list is always in right direction
            for (int i = 0; i < level.size(); i++)
                curValue.add(level.get(i).val);
            // process next list from last item in current list
            for (int i = level.size() - 1; i >= 0; i--) {
                TreeNode node = level.get(i);
                if (isForward) {
                    if (node.left != null) cur.add(node.left);
                    if (node.right != null) cur.add(node.right);
                } else {
                    if (node.right != null) cur.add(node.right);
                    if (node.left != null) cur.add(node.left);       
                }
            }
            isForward = !isForward;
            res.add(curValue);
            level = cur;
        }
        return res;
    }
}