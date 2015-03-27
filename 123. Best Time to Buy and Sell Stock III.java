public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0], max = prices[prices.length - 1], profit = 0;
        int[] past = new int[prices.length], future = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            // compare with i-1 in the past
            past[i] = Math.max(past[i - 1], prices[i] - min);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            // compare with i+1 in the future
            future[i] = Math.max(future[i + 1], max - prices[i]);

            profit = Math.max(profit, past[i] + future[i]);
        }
        return profit;
    }
}