public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        while (root.left != null) {
            for (TreeLinkNode runner = root; runner != null; runner = runner.next) {
                runner.left.next = runner.right;
                runner.right.next = runner.next == null ? null : runner.next.left;
            }
            root = root.left;
        }
    }
}