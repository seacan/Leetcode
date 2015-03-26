public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        while (root != null) {
            TreeLinkNode head = root;
            TreeLinkNode nextHead = null, last = null;
            while (head != null) {
                if (head.left != null) {
                    if (nextHead == null) {
                        nextHead = head.left;
                        last = nextHead;
                    } else {
                        last.next = head.left;
                        last = head.left;
                    }
                }
                if (head.right != null) {
                    if (nextHead == null) {
                        nextHead = head.right;
                        last = nextHead;
                    } else {
                        last.next = head.right;
                        last = head.right;
                    }
                }
                head = head.next;
            }
            if (head != null) head.next = null;
            root = nextHead;
        }
    }
}