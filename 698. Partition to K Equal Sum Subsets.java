// Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
// Output: True
// Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
class Solution {
    public boolean canPartitionKSubsets(int[] a, int k) {
        int sum = IntStream.of(a).sum();
        return k != 0 && sum % k == 0 && canPartition(a, k, new boolean[a.length], 0, 0, sum / k);
    }

    boolean canPartition(int[] a, int k, boolean[] seen, int start, int sum, int target) {
        if (k == 1) return true;
        if (sum == target)
            return canPartition(a, k - 1, seen, 0, 0, target);
        for (int i = start; i < a.length; i++)
            if (!seen[i]) {
                seen[i] = true;
                if (canPartition(a, k, seen, i + 1, sum + a[i], target))
                    return true;
                seen[i] = false;
            }
        return false;
    }
}