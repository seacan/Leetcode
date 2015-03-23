public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<TreeNode>();
        res[0].add(null);

        for(int cur = 1;cur<=n;cur++){
            res[cur] = new ArrayList<TreeNode>();
            for(int i=0;i<cur;i++)
                for(TreeNode left : res[i])
                    for(TreeNode right : res[cur-1-i]) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = left;
                        root.right = clone(right, i + 1);
                        res[cur].add(root);
                    }
        }
        return res[n];
    }

    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = clone(root.left, offset);
        newRoot.right = clone(root.right, offset);
        return newRoot;
    }
}