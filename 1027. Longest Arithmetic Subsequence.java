// Input: A = [9,4,7,2,10], Output: 3
// Explanation: The longest arithmetic subsequence is [4,7,10].
// Input: A = [20,1,15,3,10,5,8], Output: 4
// Explanation: The longest arithmetic subsequence is [20,15,10,5].
class Solution {
    public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}