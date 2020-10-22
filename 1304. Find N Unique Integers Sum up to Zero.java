// [0]
// [-1, 1]
// [-2, 0, 2]
class Solution {
    public int[] sumZero(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; ++i)
            A[i] = i * 2 - n + 1;
        return A;
    }
}