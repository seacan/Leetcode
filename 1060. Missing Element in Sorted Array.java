class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int missingNum = nums[n - 1] - nums[0] - (n - 1);       
        if (missingNum < k) {
            return nums[n - 1] + k - missingNum;
        }

        int l = 0;
        int h = n - 1;        
        while (l < h - 1) {
            int m = l + (h - l) / 2;
            int missing = nums[m] - nums[l] - (m - l);
            
            if (missing >= k) {
		// when the number is larger than k, then the index won't be located in (m, h]
                h = m;
            } else {
		// when the number is smaller than k, then the index won't be located in [l, m), update k -= missing
                k -= missing;
                l = m;
            }
        }
        
        return nums[l] + k;
    }
}