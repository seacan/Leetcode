public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        while (root != null) {
            TreeLinkNode first = null, last = null;
            for (TreeLinkNode runner = root; runner != null; runner = runner.next) {
                if (runner.left != null) {
                    if (first == null) {
                        first = runner.left;
                        last = runner.left;
                    } else {
                        last.next = runner.left;
                        last = runner.left;
                    }
                }

                if (runner.right != null) {
                    if (first == null) {
                        first = runner.right;
                        last = runner.right;
                    } else {
                        last.next = runner.right;
                        last = runner.right;
                    }
                }
            }
            root = first;
        }
    }
}