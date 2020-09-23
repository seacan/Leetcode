class Solution {
    public boolean splitArray(int[] nums) {
        if (nums.length < 7) return false;
        int n = nums.length;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < n; ++i) sums[i] = sums[i - 1] + nums[i];
        for (int j = 3; j < n - 3; ++j) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; ++i)
                if (sums[i - 1] == (sums[j - 1] - sums[i]))
                    set.add(sums[i - 1]);
            for (int k = j + 1; k < n - 1; ++k) {
                int s3 = sums[k - 1] - sums[j], s4 = sums[n - 1] - sums[k];
                if (s3 == s4 && set.contains(s3)) return true;
            }
        }
        return false;
    }
}