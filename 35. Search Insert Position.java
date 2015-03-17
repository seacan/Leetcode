public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        return searchInsertHelper(A, 0, A.length - 1, target);
    }

    private int searchInsertHelper(int[] A, int start, int end, int target) {
        if (start > end) return start;
        int mid = (start + end) / 2;
        // can handle equal case together
        if (A[mid] >= target) return searchInsertHelper(A, start, mid - 1, target);
        else return searchInsertHelper(A, mid + 1, end, target);
    }
}