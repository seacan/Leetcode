public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                if (cur.right != null) st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (!st.isEmpty() && cur == st.peek())
                cur = cur.right;
            else {
                res.add(cur.val);
                cur = null; // assign to null to avoid trace left branch again
            }
        }
        return res;
    }
}