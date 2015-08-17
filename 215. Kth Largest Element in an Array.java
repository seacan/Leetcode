public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1 && k == 1) return nums[0];
        return findKthLargestHelper(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int findKthLargestHelper(int[] nums, int start, int end, int rank) {
        int pivot = nums[end], right = end - 1;
        for (int i = start; i <= right; i++)
            if (nums[i] > pivot) {
                int temp = nums[right];
                nums[right--] = nums[i];
                nums[i--] = temp;
            }
        nums[end] = nums[++right];
        nums[right] = pivot;
        // don't forget to subtract start when comparing to rank
        if (right - start + 1 == rank) return nums[right];
        else if (right - start + 1 < rank) return findKthLargestHelper(nums, right + 1, end, rank - (right - start + 1));
        else return findKthLargestHelper(nums, start, right - 1, rank);
    }
}