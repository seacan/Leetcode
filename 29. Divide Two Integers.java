public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend >= 0) ^ (divisor >= 0);
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long res = 0, cur = 0;
        for (int i = 31; i >= 0; i--) {
            cur = cur << 1;
            cur |= (longDividend >> i) & 1;
            
            // res in each loop shifting 1 position
            res = res << 1;
            if (cur >= longDivisor) {
                res |= 1;
                cur -= longDivisor;
            }
        }
        return isNegative ? (res > Integer.MAX_VALUE ? Integer.MIN_VALUE : (int) res * -1) 
                          : (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res);
    }
}