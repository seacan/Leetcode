// Input: root = [1,2,3]
// Output: [1,2,3]
// Explanation: 
// The deepest leaves are the nodes with values 2 and 3.
// The lowest common ancestor of these leaves is the node with value 1.
// The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
class Solution {
    class Pair {
        TreeNode node;
        int d;
        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }

    private Pair getLca(TreeNode root, int d) {
        if (root == null) return new Pair(null, d);
        Pair l = getLca(root.left, d + 1);
        Pair r = getLca(root.right, d + 1);
        if (l.d == r.d)
            return new Pair(root, l.d);
        else
            return  l.d > r.d ? l : r;        
    }
}