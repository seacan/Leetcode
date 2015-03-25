public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) return null;

        TreeNode root = new TreeNode(postorder[pEnd]);
        int index = iStart;
        for (int i = iStart; i <= iEnd; i++)
            if (inorder[i] == postorder[pEnd]) {
                index = i;
                break;
            }
        root.left = buildTreeHelper(inorder, iStart, index - 1, postorder, pStart, pStart + index - iStart - 1);
        root.right = buildTreeHelper(inorder, index + 1, iEnd, postorder, pEnd - 1 - (iEnd - index - 1), pEnd - 1);
        return root;
    }
}