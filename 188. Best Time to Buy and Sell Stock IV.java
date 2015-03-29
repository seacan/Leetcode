public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k >= prices.length / 2) return maxProfitAll(prices);
        int[][] mem = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int maxPrevious = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                mem[i][j] = Math.max(mem[i][j - 1], maxPrevious + prices[j]);
                maxPrevious = Math.max(maxPrevious, mem[i - 1][j - 1] - prices[j]);
            }
        }
        return mem[k][prices.length - 1];
    }

    private int maxProfitAll(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}