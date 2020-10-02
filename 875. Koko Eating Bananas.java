class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = getMaxPile(piles);
        
        // Binary search to find the smallest valid K.
        while (lo <= hi) {
            int K = lo + ((hi - lo) >> 1);
            if (canEatAll(piles, K, H)) hi = K - 1;
            else lo = K + 1;            
        }
        
        return lo;
    }
    
    private boolean canEatAll(int[] piles, int K, int H) {
        int countHour = 0;        
        for (int pile : piles)
            countHour += Math.ceil((double) pile / K);
        return countHour <= H;
    }
    
    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles)
            maxPile = Math.max(pile, maxPile);    
        return maxPile;
    }
}