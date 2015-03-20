public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return new int[]{1};
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        int pad = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i] + pad;
            digits[i] = cur % 10;
            pad = cur > 9 ? 1 : 0;
        }
        if (pad == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = pad;
            for (int i = 1; i < res.length; i++) res[i] = digits[i - 1];
            return res;
        }
        return digits;
    }
}