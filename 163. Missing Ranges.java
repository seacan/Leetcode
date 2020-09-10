public class Solution {
    List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int num : nums) {
            if (num > lower)
                res.add((new StringBuilder()).append(lower).append(num - 1 > lower ? "->" + (num - 1) : "").toString());
            if (num == upper) return res;
            lower = num + 1;
        }
        if (lower <= upper)
            res.add((new StringBuilder()).append(lower).append(upper > lower ? "->" + upper : "").toString());
        return res;
    }
}