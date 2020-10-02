// Input: arr = [3,2,4,1]
// Output: [4,2,4,3]
// Explanation: 
// We perform 4 pancake flips, with k values 4, 2, 4, and 3.
// Starting state: arr = [3, 2, 4, 1]
// After 1st flip (k = 4): arr = [1, 4, 2, 3]
// After 2nd flip (k = 2): arr = [4, 1, 2, 3]
// After 3rd flip (k = 4): arr = [3, 2, 1, 4]
// After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
class Solution {
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int end = A.length - 1;
        while (end > 0) {
            int max = A[0], index = 0;
            //find the index of the max element in current unsorted part of the array; up to len
            for (int i = 0; i <= end; i++)
                if (A[i] > max) {
                    max = A[i];
                    index = i;
                }

            //if max is at last position, no need to do any flips
            if (index == end) {
                end--;
                continue;
            }

            result.add(index + 1);
            reverse(A, index);
            result.add(end + 1);
            reverse(A, end);
            end--;
        }

        return result;
    }

    public static void reverse(int[] A, int end) {
        int left = 0, right = end;
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
    }
}