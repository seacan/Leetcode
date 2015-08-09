public class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int total = n - 2;
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                for (int j = 2; i * j < n; j++)
                    if (isPrime[i * j]) {
                        isPrime[i * j] = false;
                        total--;
                    }
        return total;
    }
}