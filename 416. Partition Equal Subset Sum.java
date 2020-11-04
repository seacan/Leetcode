// Input: [1, 5, 11, 5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];

        dp[0][0] = true;
        for (int i = 1; i < n; i++) dp[i][0] = true;
        for (int j = 1; j <= sum; j++) dp[0][j] = false;

        for (int i = 1; i < n; i++)
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1])
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
            }

        return dp[n-1][sum];
    }
}