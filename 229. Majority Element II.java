public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) return res;
        int n1 = 0, n2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == n1) count1++;
            else if (num == n2) count2++;
            else if (count1 == 0) {
                n1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                n2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == n1) count1++;
            else if (num == n2) count2++;
        }
        if (count1 > nums.length / 3) res.add(n1);
        if (count2 > nums.length / 3) res.add(n2);
        return res;
    }
}