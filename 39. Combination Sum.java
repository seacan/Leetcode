/* The same repeated number may be chosen from C unlimited number of times. */

// Solution 1: add several numbers with the same value every time
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, sol, res);
        return res;
    }

    private void combinationSumHelper(int[] candidates, int index, int target, List<Integer> sol, List<List<Integer>> res) {
        // check target value first
        if (target == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (index == candidates.length) return;

        for (int i = 0; target - candidates[index] * i >= 0; i++) {
            for (int j = 0; j < i; j++) sol.add(candidates[index]);
            combinationSumHelper(candidates, index + 1, target - candidates[index] * i, sol, res);
            for (int j = 0; j < i; j++) sol.remove(sol.size() - 1);
        }
    }
}

// Solution 2: add one number at a time
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}