public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int index = 1, pre = A[0];
        for (int i = 1; i < A.length; i++)
            if (A[i] != pre) {
                A[index++] = A[i];
                pre = A[i];
            }
        return index;
    }
}