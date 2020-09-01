public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            int res = 0;
            for (int n : nums) res += n;
            return res;
        }

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return target;
                else {
                    if (Math.abs(sum - target) < Math.abs(res - target))
                        res = sum;
                    if (sum >= target) r--;
                    else l++;
                }
            }
        }
        return res;
    }
}