class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) return false;

        TreeSet<Long> sets = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long max = sets.floor((long)nums[i] + t), min = sets.ceiling((long)nums[i] - t);
            if ((max != null && nums[i] <= max) || (min != null && nums[i] >= min))
                return true;
            sets.add((long)nums[i]);
            if (i >= k) sets.remove((long)nums[i - k]);
        }
        return false;
    }
}