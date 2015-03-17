public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) return new int[]{-1, -1};
        return searchRangeHelper(A, 0, A.length - 1, target);
    }

    private int[] searchRangeHelper(int[] A, int start, int end, int target) {
        if (start > end) return new int[]{-1, -1};
        int mid = (start + end) / 2;
        if (target < A[mid]) return searchRangeHelper(A, start, mid - 1, target);
        else if (target > A[mid]) return searchRangeHelper(A, mid + 1, end, target);
        else {
            int[] res = new int[]{mid, mid};
            int first = mid, second = mid;
            while (first != -1) {
                // search for range except mid
                first = binarySearch(A, start, first - 1, target);
                if (first != -1) res[0] = first;
            }
            while (second != -1) {
                second = binarySearch(A, second + 1, end, target);
                if (second != -1) res[1] = second;
            }
            return res;
        }
    }

    private int binarySearch(int[] A, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (A[mid] == target) return mid;
        else if (A[mid] > target) return binarySearch(A, start, mid - 1, target);
        else return binarySearch(A, mid + 1, end, target);
    }
}