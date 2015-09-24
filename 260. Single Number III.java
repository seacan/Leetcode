public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^= num;

        int set = 1;
        while ((diff & 1) != 1) {
            diff >>= 1;
            set <<= 1;
        }

        int[] res = {0, 0};
        for (int num : nums)
            if ((num & set) == 0) res[0] ^= num;
            else res[1] ^= num;
        return res;
    }
}