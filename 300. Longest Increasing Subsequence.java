// Input: [10,9,2,5,3,7,101,18]
// Output: 4 
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            // insert each num to tails with binary search
            int i = 0, j = size;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = num;
            if (i == size) ++size;
        }
        return size;
    }
}