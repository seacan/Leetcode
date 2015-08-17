public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) return false;

        TreeSet<Integer> sets = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer max = sets.floor(nums[i] + t), min = sets.ceiling(nums[i] - t);
            if ((max != null && nums[i] <= max) || (min != null && nums[i] >= min))
                return true;
            sets.add(nums[i]);
            if (i >= k) sets.remove(nums[i - k]);
        }
        return false;
    }
}