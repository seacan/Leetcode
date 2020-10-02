// Input: n = 1, Output: 10
// Input: n = 2, Output: 20
// Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
class Solution {
    public int knightDialer(int N) {
        if (N == 1) return 10;
        long mod = 1000000007;
        long[] pre = new long[10];  // to record previous result. It is needed because if we only use cur, the cur array itself is changed during calculation.
        long[] cur = new long[10];  // to record current result.
        Arrays.fill(pre, 1);
        while (--N > 0) {
            cur[0] = (pre[4] + pre[6]) % mod;
            cur[1] = (pre[6] + pre[8]) % mod;
            cur[2] = (pre[7] + pre[9]) % mod;
            cur[3] = (pre[4] + pre[8]) % mod;
            cur[4] = (pre[3] + pre[9] + pre[0]) % mod;
            //cur[5]=0;
            cur[6] = (pre[1] + pre[7] + pre[0]) % mod;
            cur[7] = (pre[2] + pre[6]) % mod;
            cur[8] = (pre[1] + pre[3]) % mod;
            cur[9] = (pre[2] + pre[4]) % mod;
            for (int i = 0; i < 10; i++) pre[i] = cur[i];  //Right for it's value copy(deep copy).
        }
        long sum = 0;
        for (int i = 0; i < 10; i++)
            sum = (sum + cur[i]) % mod;
        return (int) sum;
    }
}