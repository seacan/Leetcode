// Input: s = "abc", t = "ahbgdc"
// Output: true
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(indexS))
                indexS++;
            if (indexS == s.length()) return true;
        }
        return false;
    }
}