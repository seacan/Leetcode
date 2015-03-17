public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        return searchHelper(A, 0, A.length - 1, target);
    }

    private int searchHelper(int[] A, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (A[mid] == target) return mid;
        
        if (A[start] <= A[mid]) {
            // use <= 
            if (A[start] <= target && target <= A[mid])
                return searchHelper(A, start, mid - 1, target);
            else
                return searchHelper(A, mid + 1, end, target);
        } else {
            // use <= 
            if (A[mid] <= target && target <= A[end])
                return searchHelper(A, mid + 1, end, target);
            else
                return searchHelper(A, start, mid - 1, target);
        }
    }
}