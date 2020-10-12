// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;

        while (j < nums.length) {
            while (sum < s && j < nums.length)
                sum += nums[j++];            
            while (sum >= s) {
                ans = Math.min(ans, j - i);
                sum -= nums[i++];
            }
        }

        return (ans == Integer.MAX_VALUE ? 0 : ans);
    }
}