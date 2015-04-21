/* Each number in C may only be used once in the combination. */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(num);
        combinationSum2Helper(num, 0, target, sol, res);
        return res;
    }

    private void combinationSum2Helper(int[] num, int index, int target, List<Integer> sol, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (index == num.length) return;

        for (int i = index; i < num.length && target - num[i] >= 0; i++) {
            if (i > index && num[i] == num[i] == num[i - 1]) continue; // skip using the same value at same position
            sol.add(num[i]);
            combinationSum2Helper(num, i + 1, target - num[i], sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}