public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
            // remove the oldest element
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}