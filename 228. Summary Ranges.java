public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) return res;
        for (int start = 0; start < nums.length; ) {
            int end = start;
            for (; end < nums.length - 1 && nums[end] + 1 == nums[end + 1]; end++) ;
            StringBuilder sb = new StringBuilder();
            if (start == end) {
                sb.append(nums[start]);
                res.add(sb.toString());
            } else {
                sb.append(nums[start]);
                sb.append("->");
                sb.append(nums[end]);
                res.add(sb.toString());
            }
            start = end + 1;
        }
        return res;
    }
}