class Solution {
    public int minKBitFlips(int[] A, int K) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (i + K > A.length) return -1;
                flip(A, K, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void flip(int[] A, int K, int i) {
        for (int j = i; j < i + K; j++)
            A[j] = 1 - A[j];        
    }
}