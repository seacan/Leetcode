public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node levelRunner = root;
        while (levelRunner != null) {
            Node first = null, last = null;
            for (Node rowRunner = levelRunner; rowRunner != null; rowRunner = rowRunner.next) {
                if (rowRunner.left != null) {
                    if (first == null) {
                        first = rowRunner.left;
                        last = rowRunner.left;
                    } else {
                        last.next = rowRunner.left;
                        last = rowRunner.left;
                    }
                }

                if (rowRunner.right != null) {
                    if (first == null) {
                        first = rowRunner.right;
                        last = rowRunner.right;
                    } else {
                        last.next = rowRunner.right;
                        last = rowRunner.right;
                    }
                }
            }
            levelRunner = first;
        }
        return root;
    }
}