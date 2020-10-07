// Input: steps = 3, arrLen = 2
// Output: 4
// Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
// Right, Left, Stay
// Stay, Right, Left
// Right, Stay, Left
// Stay, Stay, Stay
class Solution {
    public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(steps, arrLen);
        long[][] dp = new long[steps + 1][maxPos + 1];

        dp[1][0] = 1;  // stay
        dp[1][1] = 1;  // left
        for (int i = 2; i <= steps; i++)
            for (int j = 0; j < maxPos; j++)
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1] + (j > 0 ? dp[i - 1][j - 1] : 0)) % 1000000007;

        return (int) dp[steps][0];
    }
}