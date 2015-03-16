public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) break;
            int p = i, q = 0;
            while (q < needle.length() && haystack.charAt(p) == needle.charAt(q)) {
                p++;
                q++;
            }
            if (q == needle.length()) return i;
        }
        return -1;
    }
}