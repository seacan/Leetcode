// Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
// Return the length of the longest (contiguous) subarray that contains only 1s.
class Solution {
    public int longestOnes(int[] A, int K) {
        int maxLength = 0, start = 0, zeroCount = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0)
                zeroCount++;
            while (zeroCount > K) {
                if (A[start] == 0)
                    zeroCount--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}