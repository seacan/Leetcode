// Given a non-empty binary search tree and a target value, find  k  values in the BST that are closest to the target.

// Solution 1: recursion
public class Solution {
    List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root, target, k, res);
        return res;
    }

    void inorder(TreeNode root, double target, int k, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, target, k, res);
        if (res.size() < k) res.add(root.val);
        else if (Math.abs(root.val - target) < Math.abs(res.get(0) - target)) {
            res.remove(0);
            res.add(root.val);
        } else return;
        inorder(root.right, target, k, res);
    }
}

// Solution 2: iteration
public class Solution {
    List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (res.size() < k) res.add(cur.val);
            else if (Math.abs(cur.val - target) < Math.abs(res.get(0) - target)) {
                res.remove(0);
                res.add(cur.val);
            } else break;
            cur = cur.right;
        }
        return res;
    }
}