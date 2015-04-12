// Solution 1: divide and conquer
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        List<Integer> res = new ArrayList<Integer>();
        res.add(root.val);
        for(int i=0;i<Math.max(left.size(), right.size());i++){
            if(i>=right.size())
                res.add(left.get(i));
            else
                res.add(right.get(i));
        }
        return res;
    }
}

//Solution 2: 
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rideSideNodes = new ArrayList<Integer>();
        levelOrder(root, 1, rideSideNodes);
        return rideSideNodes;
    }

    private void levelOrder(TreeNode root, int currentLevel, List<Integer> rideSideNodes) {
        if (root == null) return;
        if (currentLevel > rideSideNodes.size()) rideSideNodes.add(root.val);
        levelOrder(root.right, currentLevel + 1, rideSideNodes);
        levelOrder(root.left, currentLevel + 1, rideSideNodes);
    }
}