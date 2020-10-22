// Input: A = [0,0,0,1,0,1,1,0], K = 3
// Output: 3
// Explanation:
// Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
// Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
// Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]
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