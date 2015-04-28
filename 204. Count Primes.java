public class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] isNonPrime = new boolean[n];
        int total = n - 2;
        for (int i = 2; i < n; i++)
            if (!isNonPrime[i])
                for (int j = 2; i * j < n; j++)
                    if (!isNonPrime[i * j]) {
                        isNonPrime[i * j] = true;
                        total--;
                    }
        return total;
    }
}