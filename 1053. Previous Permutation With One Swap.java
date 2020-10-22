// Input: [3,1,1,3]
// Output: [1,3,1,3]
// Explanation: Swapping 1 and 3.
class Solution {
    public int[] prevPermOpt1(int[] A) {
        if (A.length <= 1) return A;
        int idx = -1;
        // find the largest i such that A[i] > A[i + 1]
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i] < A[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        // the array already sorted, not smaller permutation
        if (idx == -1) return A;
        // find the rightmost i such that A[i] < A[idx], then swap them
        for (int i = A.length - 1; i > idx; i--) {
            // the second check to skip duplicate numbers
            if (A[i] < A[idx] && A[i] != A[i - 1]) {
                int tmp = A[i];
                A[i] = A[idx];
                A[idx] = tmp;
                break;
            }
        }
        return A;
    }
}