// Solution 1. Optimized solution, 1 round
public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;
        int l = 0, r = A.length - 1, level = 0;
        int total = 0, block = 0;
        while (l <= r) {
            if (A[l] > level && A[r] > level) {
                total += (r - l + 1) * (Math.min(A[l], A[r]) - level);
                level = Math.min(A[l], A[r]);
            }

            // move the pointer with less height
            if (A[l] <= A[r]) block += A[l++];
            else block += A[r--];
        }

        return total - block;
    }
}



// Solution 2. Max height rounds
public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;
        int total = 0;
        while (true) {
            int l = 0, r = A.length - 1;
            while (A[l] == 0 && l < r) l++;
            while (A[r] == 0 && l < r) r--;

            if (l == r) return total;
            for (int i = l; i <= r; i++) {
                if (A[i] == 0) total++;
                A[i] = A[i] == 0 ? 0 : A[i] - 1;
            }
        }
    }
}