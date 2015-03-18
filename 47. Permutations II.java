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
            if (used[i]) continue;
            // if index is 0, or current num is different as previous position
            // or previous one is not used (postion greater than 0, and current num is same as previous one)
            if (i == 0 || num[i - 1] != num[i] || !used[i - 1]) {
                used[i] = true;
                sol.add(num[i]);
                permuteUniqueHelper(num, used, sol, res);
                sol.remove(sol.size() - 1);
                used[i] = false;
            }
        }
    }
}