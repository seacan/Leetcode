public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
                    // move left and right only 1 solution is found, only move when l<r
                    // check l and its previous one, r and its afer one
                    do l++; while (l < r && nums[l] == nums[l - 1]);
                    do r--; while (l < r && nums[r] == nums[r + 1]);
                } else if (nums[i] + nums[l] + nums[r] > 0) r--;
                else l++;
            }
        }
        return res;
    }
}