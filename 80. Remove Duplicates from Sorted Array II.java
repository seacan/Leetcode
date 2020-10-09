// Given nums = [1,1,1,2,2,3],
// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
// It doesn't matter what you leave beyond the returned length.
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int count = 1, cur = A[0], index = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == cur) {
                if (++count <= 2)
                    A[index++] = A[i];
            } else {
                A[index++] = A[i];
                cur = A[i];
                count = 1;
            }
        }
        return index;
    }
}