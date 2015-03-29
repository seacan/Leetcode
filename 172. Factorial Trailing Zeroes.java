public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 1; n / Math.pow(5, i) > 0; i++)
            res += n / Math.pow(5, i);
        return res;
    }
}