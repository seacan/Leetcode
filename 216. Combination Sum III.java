// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
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
        for (int i = index; i <= 9 && sum - i >= 0; i++) {
            sol.add(i);
            combinationSum3Helper(i + 1, total, sum - i, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}