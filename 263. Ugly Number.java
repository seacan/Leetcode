// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
// Input: 6, Output: true, Explanation: 6 = 2 × 3
public class Solution {
    public boolean isUgly(int num) {
        if (num > 0)
            for (int i = 2; i < 6; i++)
                while (num % i == 0)
                    num /= i;
        return num == 1;
    }
}