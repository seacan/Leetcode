public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        while (root != null) {
            TreeLinkNode head = root;
            while (head != null) {
                if (head.left != null)
                    head.left.next = head.right;
                if (head.right != null)
                    head.right.next = head.next != null ? head.next.left : null;
                head = head.next;
            }
            root = root.left != null ? root.left : null;
        }
    }
}