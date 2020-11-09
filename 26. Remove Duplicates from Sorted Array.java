class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;        
        int cur = 0;
        for (int i = 0; i < A.length; i++, cur++) {
            A[cur] = A[i];            
            if (cur > 0 && A[cur] == A[cur - 1]) cur--;
        }
        return cur;
    }
}