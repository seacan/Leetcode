public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            // j decreases to i+3
            for (int j = nums.length - 1; j >= i + 3; j--) {
                if (j < nums.length - 1 && nums[j + 1] == nums[j]) continue;
                int l = i + 1, r = j - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r] + nums[j];
                    if (sum == target) {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r], nums[j])));
                        do l++; while (l < r && nums[l] == nums[l - 1]);
                        do r--; while (l < r && nums[r] == nums[r + 1]);
                    } else if (sum > target) r--;
                    else l++;
                }
            }
        }
        return res;
    }
}