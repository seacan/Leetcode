public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        permuteUniqueHelper(num, used, sol, res);
        return res;
    }

    private void permuteUniqueHelper(int[] num, boolean[] used, List<Integer> sol, List<List<Integer>> res) {
        if (sol.size() == num.length) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (used[i] || i > 0 && num[i] == num[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            sol.add(num[i]);
            permuteUniqueHelper(num, used, sol, res);
            sol.remove(sol.size() - 1);
            used[i] = false;
        }
    }
}