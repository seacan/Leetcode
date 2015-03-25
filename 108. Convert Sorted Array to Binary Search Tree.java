public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }
    
    private TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTHelper(num, start, mid - 1);
        root.right = sortedArrayToBSTHelper(num, mid + 1, end);
        return root;
    }
}