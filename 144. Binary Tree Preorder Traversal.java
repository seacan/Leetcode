public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            list.add(cur.val);
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }

        return list;
    }
}