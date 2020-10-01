// Input: [2,2,3,4]
// Output: 3
// Explanation: Valid combinations are: 2,3,4 (using the first 2), 2,3,4 (using the second 2), 2,2,3
class Solution {
    public int triangleNumber(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = A.length - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r)
                if (A[l] + A[r] > A[i]) {
                    count += r - l;   // count range
                    r--;
                } else l++;            
        }
        return count;
    }
}