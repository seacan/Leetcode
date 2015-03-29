public class Solution {
    public int majorityElement(int[] num) {
        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                major = num[i];
                count = 1;
            } else if (num[i] == major) {
                count++;
                if (count > num.length / 2) return major;
            } else count--;
        }
        return major;
    }
}