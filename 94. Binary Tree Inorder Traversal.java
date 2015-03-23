public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            // check cur to avoid search left tree branch multiple times
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }

            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}