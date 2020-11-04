// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1; // not valid
        if (rem == 0) return 0; // completed
        if (count[rem] != 0) return count[rem]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }
}