class Solution {
    public Node connect(Node root) {
        if (root == null) return null;        
        Node levelRunner = root;
        while (levelRunner.left != null) {
            for (Node rowRunner = levelRunner; rowRunner != null; rowRunner = rowRunner.next) {
                rowRunner.left.next = rowRunner.right;
                rowRunner.right.next = rowRunner.next == null ? null : rowRunner.next.left;
            }
            levelRunner = levelRunner.left;
        }
        return root;
    }
}