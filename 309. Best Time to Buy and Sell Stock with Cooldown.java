class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int curBuy = -prices[0], perBuy = curBuy;
        int curSell = 0, preSell = 0, coolDownSell = 0;

        for (int i = 1; i < prices.length; i++) {
            curBuy = Math.max(perBuy, coolDownSell - prices[i]);
            curSell = Math.max(preSell, perBuy + prices[i]);
            perBuy = curBuy;
            coolDownSell = preSell;
            preSell = curSell;
        }
        return curSell;
    }
}