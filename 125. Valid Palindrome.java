public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return true;
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l<r) l++;
            while (!Character.isLetterOrDigit(s.charAt(r)) && l<r) r--;
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}