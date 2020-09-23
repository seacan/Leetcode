public class Solution {
    // Solution 1: iteration
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

    // Solution 2: recursion
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double res = myPow(x, n / 2);
        return n % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
    }
}