// Input: “aabcaabdaab”
// Output: 3
// Explanation: The longest repeating substring is “aab”, which occurs 3 times.
class Solution {
    public int longestRepeatingSubstring(String S) {
        if (S == null || S.length() == 0) return 0;

        int res = 0, n = S.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j < i; j++)
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }

        return res;
    }
}