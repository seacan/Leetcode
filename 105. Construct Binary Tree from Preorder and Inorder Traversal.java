public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;

        TreeNode root = new TreeNode(preorder[pStart]);
        int index = iStart;
        for (int i = iStart; i <= iEnd; i++)
            if (inorder[i] == preorder[pStart]) {
                index = i;
                break;
            }
        root.left = buildTreeHelper(preorder, pStart + 1, pStart + index - iStart, inorder, iStart, index - 1);
        root.right = buildTreeHelper(preorder, pEnd + index - iEnd + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }
}