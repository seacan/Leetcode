// Solution 1: two loops
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

// Solution 2: 4 cases on each day
class Solution {
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}