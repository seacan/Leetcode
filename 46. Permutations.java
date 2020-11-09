// Solution 1: recursive one based on n-1 result
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        return permuteHelper(num, num.length - 1);
    }

    private List<List<Integer>> permuteHelper(int[] num, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index == 0) {
            res.add(new ArrayList<Integer>(Arrays.asList(num[index])));
            return res;
        }

        List<List<Integer>> pre = permuteHelper(num, index - 1);
        for (List<Integer> sol : pre) {
            for (int i = 0; i < sol.size() + 1; i++) {
                List<Integer> copy = new ArrayList<Integer>(sol);
                copy.add(i, num[index]);
                res.add(copy);
            }
        }
        return res;
    }
}

// Solution 2: backtracking
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used, sol, res);
        return res;
    }

    private void permuteHelper(int[] nums, boolean[] used, List<Integer> sol, List<List<Integer>> res) {
        if (sol.size() == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            sol.add(nums[i]);
            permuteHelper(nums, used, sol, res);
            sol.remove(sol.size() - 1);
            used[i] = false;
        }
    }
}