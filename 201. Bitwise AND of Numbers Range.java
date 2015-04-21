public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int tail = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            tail <<= 1;
        }
        return m * tail;
    }
}