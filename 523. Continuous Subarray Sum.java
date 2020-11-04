// Input: [23, 2, 6, 4, 7],  k=6
// Output: True
// Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42 (6*7).
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else map.put(runningSum, i);  // always keep the mininum i
        }
        return false;
    }
}