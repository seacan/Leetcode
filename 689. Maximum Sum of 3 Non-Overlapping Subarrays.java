// Input: [1,2,1,2,6,7,5,1], 2
// Output: [0, 3, 5]
// Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
// We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;

        // this is very important because otherwise i+k is going to out of bounds.
        int len = nums.length;
        int[] sum = new int[len + 1];
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[3];
        int max = 0;

        // Computing the running sum
        // sum[i] stores the value from index 0 to i-1
        for (int i = 1; i <= len; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        // traversing from left to right
        int leftMax = sum[k] - sum[0];
        left[k - 1] = 0;
        for (int i = k; i < len; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > leftMax) {
                left[i] = i - k + 1;
                leftMax = sum[i + 1] - sum[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }

        // traversing from right to left
        int rightMax = sum[len] - sum[len - k];
        right[len - k] = len - k;
        for (int i = len - k - 1; i >= 0; i--) {
            if (sum[i + k] - sum[i] > rightMax) {
                right[i] = i;
                rightMax = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }

        // now consider the middle part where k<=i<=n-2k
        for (int i = k; i <= len - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int total = (sum[l + k] - sum[l]) + (sum[i + k] - sum[i]) + (sum[r + k] - sum[r]);
            if (total > max) {
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}