// Solution 1. Treat left and right subtree separately
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);

        root.left = null;
        if (left != null) {
            root.right = left;
            while (left.right != null) left = left.right;
            left.right = right;
        }
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