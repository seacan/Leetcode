public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int start, int end) {
        int preInclude = 0, preExclude = 0;
        for (int i = start; i <= end; i++) {
            int include = nums[i] + preExclude;
            int exclude = Math.max(preExclude, preInclude);
            preInclude = include;
            preExclude = exclude;
        }
        return Math.max(preExclude, preInclude);
    }
}