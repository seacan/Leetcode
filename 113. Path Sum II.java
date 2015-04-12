// Solution 1. Classic recursive function
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        pathSumHelper(root, sum, sol, res);
        return res;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> sol, List<List<Integer>> res) {
        if (root == null)   return;
        
        if (root.left == null && root.right == null && root.val == sum){
            List<Integer> copy = new ArrayList<Integer>(sol);
            copy.add(root.val);
            res.add(copy);
            return;
        }

        sol.add(root.val);
        pathSumHelper(root.left, sum - root.val, sol, res);       
        pathSumHelper(root.right, sum - root.val, sol, res);
        sol.remove(sol.size() - 1);

    }
}


// Solution 2: In only one function
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        
        if(root==null){
            return pathList;
        }
        
        if(root.left==null&&root.right==null){//if find a path, create a new list and add to the pathList.
            if(root.val==sum){
                List<Integer> list = new ArrayList<Integer>();
                list.add(root.val);
                pathList.add(list);
            }
            return pathList;
        }
        
        //find path left and right child and merge two list together.
        pathList = pathSum(root.left, sum-root.val);
        List<List<Integer>> pathList_right = pathSum(root.right, sum-root.val);
        for(List<Integer> l:pathList_right){
            pathList.add(l);
        }
        
        //add current root to every list in path list.
        for(List<Integer> l:pathList){
            l.add(0, root.val);
        }
        return pathList;
    }
}