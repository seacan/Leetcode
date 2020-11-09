// Given nums = [1,1,1,2,2,3],
// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
// It doesn't matter what you leave beyond the returned length.
class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] count = new int[A.length];
        int cur = 0;
        for (int i = 0; i < A.length; i++, cur++) {
            A[cur] = A[i];
            count[cur] = (cur > 0 && A[cur] == A[cur - 1]) ? count[cur - 1] + 1 : 1;
            if (count[cur] >= 3) cur--;
        }
        return cur;
    }
}