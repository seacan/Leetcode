class Solution {
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r) 
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
        return true;
    }

    private boolean isPalindromic(String s, int l, int r) {
        while (++l < --r) 
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) {
                int i1 = i, j1 = j - 1, i2 = i + 1, j2 = j;
                while (i1 < j1 && s.charAt(i1) == s.charAt(j1)) { i1++; j1--; }
                while (i2 < j2 && s.charAt(i2) == s.charAt(j2)) { i2++; j2--; }                
                return i1 >= j1 || i2 >= j2;
            }
        return true;
    }
}