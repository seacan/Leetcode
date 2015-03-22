public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        combineHelper(n, k, 1, sol, res);
        return res;
    }

    private void combineHelper(int n, int k, int index, List<Integer> sol, List<List<Integer>> res) {
        if (sol.size() == k) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }

        for (int i = index; i <= n; i++) {
            sol.add(i);
            combineHelper(n, k, i + 1, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}