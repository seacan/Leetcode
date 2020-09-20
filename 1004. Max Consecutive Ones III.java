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