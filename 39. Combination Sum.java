/* The same repeated number may be chosen from C unlimited number of times. */

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
        if (index >= candidates.length) return;

        for (int i = 0; target - candidates[index] * i >= 0; i++) {
            for (int j = 0; j < i; j++) sol.add(candidates[index]);
            combinationSumHelper(candidates, index + 1, target - candidates[index] * i, sol, res);
            for (int j = 0; j < i; j++) sol.remove(sol.size() - 1);
        }
    }
}