class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i], j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = temp;
                i--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                res.add(i + 1);
        }
        return res;
    }
}