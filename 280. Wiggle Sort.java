// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
public class Solution {
    void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) return;
        for (int i = 2; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
    }

    void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++)
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
    }
}