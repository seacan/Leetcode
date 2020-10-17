// Input: [4, 6, 7, 7]
// Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> sol, List<List<Integer>> res) {
        if (sol.size() > 1) res.add(new LinkedList<Integer>(sol));
        // local used, otherwise [4,6,7,7] will not be added
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (sol.isEmpty() || nums[i] >= sol.get(sol.size() - 1)) {
                used.add(nums[i]);
                sol.add(nums[i]);
                helper(nums, i + 1, sol, res);
                sol.remove(sol.size() - 1);
            }
        }
    }
}