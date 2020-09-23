class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length(), p = 0, cnt = 0;
        for (int i = 0; i < abbr.length(); ++i) {
            if (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                if (cnt == 0 && abbr.charAt(i) == '0') return false;
                cnt = 10 * cnt + abbr.charAt(i) - '0';
            } else {
                p += cnt;
                if (p >= m || word.charAt(p++) != abbr.charAt(i)) return false;
                cnt = 0;
            }
        }
        return p + cnt == m;
    }
}