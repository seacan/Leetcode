public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        combinationSum3Helper(1, k, n, sol, res);
        return res;
    }

    private void combinationSum3Helper(int index, int total, int sum, List<Integer> sol, List<List<Integer>> res) {
        if (sol.size() == total && sum == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }

        if (sol.size() > total) return;
        for (int i = index; i <= 9; i++) {
            sol.add(i);
            combinationSum3Helper(i + 1, total, sum - i, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}