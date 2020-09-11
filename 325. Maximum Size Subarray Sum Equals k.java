class Solution {
    public static int maxSubArrayLen(List<Integer> nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            if (sum == k) res = i + 1;
            else if (map.containsKey(sum - k)) res = Math.max(res, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return res;
    }
}