public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;

        while (j < nums.length) {
            while (sum < s && j < nums.length) {
                sum += nums[j++];
            }
            while (sum >= s) {
                ans = Math.min(ans, j - i);
                sum -= nums[i++];
            }
        }

        return (ans == Integer.MAX_VALUE ? 0 : ans);
    }
}