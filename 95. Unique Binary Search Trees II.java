// Solution 1: iterative solution
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

// Solution 2: recursive solution
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n<=0) return new ArrayList<TreeNode>(); 
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);
            for (TreeNode lnode : left)
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
        }
        return list;
    }
}