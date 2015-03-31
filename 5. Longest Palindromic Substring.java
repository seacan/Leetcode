public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        String res = null;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i + 1;
            for (; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) ;
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                res = s.substring(l + 1, r);
            }
            for (l = i, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) ;
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                res = s.substring(l + 1, r);
            }
        }
        return res;
    }
}