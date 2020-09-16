class Solution {
    public int triangleNumber(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = A.length - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r)
                if (A[l] + A[r] > A[i]) {
                    count += r - l;
                    r--;
                } else l++;            
        }
        return count;
    }
}