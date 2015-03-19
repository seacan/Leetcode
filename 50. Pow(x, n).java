public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0){ 
            x = 1 / x;
            n = -n;
        }

        double res = 1;
        for (double factor = x; n > 0; n = n >> 1) {
            if (n % 2 == 1) res = res * factor;
            // even n is odd, still square the factor
            factor = factor * factor;
        }
        return res;
    }
}