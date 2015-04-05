// Solution 1. recursive solution
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        flatten(left);
        root.left = null;
        if (left != null) {
            root.right = left;
            while (left.right != null) left = left.right;
            left.right = right;
        }
        flatten(right);
    }
}


// Solution 2. Connect last node in left subtree with first node in right subtree
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                TreeNode temp = left;
                while (temp.right != null)
                    temp = temp.right;
                temp.right = right;
                node.right = left;
                node.left = null;
            }
            node = node.right;
        }
    }
}