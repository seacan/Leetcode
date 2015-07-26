public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) return 1;
        for (int i = 0; i < A.length; i++)
            if (A[i] != i + 1 && A[i] - 1< A.length && A[i] - 1>= 0) {
                // only swap when target position has different value
                if (A[A[i] - 1] != A[i]) {
                    int temp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = temp;
                    i--;
                }
            }

        for (int i = 0; i < A.length; i++)
            if (A[i] != i + 1)
                return i + 1;
        // return the position after end
        return A.length + 1;
    }
}