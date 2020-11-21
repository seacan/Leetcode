// Input: nums = [1, -1, 5, -2, 3], k = 3
// Output: 4
// Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
class Solution {
    public static int maxSubArrayLen(List<Integer> nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            if (map.containsKey(sum - k)) res = Math.max(res, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);   // record most left pos
        }
        return res;
    }
}