class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[i], j = nums[i] - 1;
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i--;
                } else return nums[i];
            }
        }

        return -1;
    }
}