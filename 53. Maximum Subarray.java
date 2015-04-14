public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0], sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (sum < 0) sum = 0;
            sum += A[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}