public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) return 0;
        int lastMin = A[0], lastMax = A[0], max = A[0];
        for (int i = 1; i < A.length; i++) {
            int curMax = Math.max(A[i], Math.max(lastMax * A[i], lastMin * A[i]));
            int curMin = Math.min(A[i], Math.min(lastMax * A[i], lastMin * A[i]));
            max = Math.max(max, curMax);
            lastMax = curMax;
            lastMin = curMin;
        }
        return max;
    }
}