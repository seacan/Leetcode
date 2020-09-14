class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;

            int num = nums[i];
            if (num == -1) continue;
            if (nums[num - 1] == num) {
                res.add(num);
                nums[i] = -1;
                continue;
            }
            swap(nums, i, num - 1);
            i--;
        }
        return res;
    }

    public void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}