// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
// Input:  "69", Output: true
// Input:  "88", Output: true
public class Solution {
    boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (num.charAt(l) == num.charAt(r)) {
                if (num.charAt(l) != '1' && num.charAt(l) != '0' && num.charAt(l) != '8')
                    return false;
            }
            else if ((num.charAt(l) != '6' || num.charAt(r) != '9') && (num.charAt(l) != '9' || num.charAt(r) != '6'))
                return false;
            ++l;
            --r;
        }
        return true;
    }
}