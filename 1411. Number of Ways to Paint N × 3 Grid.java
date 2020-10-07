// no two cells that share vertical or horizontal sides have the same colour
class Solution {
    // pattern 121: 121, 131, 212, 232, 313, 323.
    // pattern 123: 123, 132, 213, 231, 312, 321.
    // So we initialize a121 = 6, a123 = 6.
    //
    // Patter 121 can be followed by: 212, 213, 232, 312, 313
    // Patter 123 can be followed by: 212, 231, 312, 232
    //
    // 121 => three 121, two 123
    // 123 => two 121, two 123
    //
    // So we can write this dynamic programming transform equation:
    // b121 = a121 * 3 + a123 * 2
    // b123 = a121 * 2 + a123 * 2
    public int numOfWays(int n) {
        long a121 = 6, a123 = 6, b121, b123, mod = (long) 1e9 + 7;
        for (int i = 1; i < n; ++i) {
            b121 = a121 * 3 + a123 * 2;
            b123 = a121 * 2 + a123 * 2;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }
        return (int) ((a121 + a123) % mod);
    }
}