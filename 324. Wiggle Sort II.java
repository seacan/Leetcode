// Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        // for first half (m-1..0), place on 0,2,..
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        // for second half (n-1..m), place on 1,3,..
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }
}