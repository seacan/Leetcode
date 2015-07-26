public class Solution {
    public boolean isMatch(String s, String p) {
        int sp = 0, pp = 0, spLast = 0, ppLast = -1;
        while (sp < s.length()) {
            // check pp within the loop, so that it could track back
            // think about "hi" and "*?" test case
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                ppLast = ++pp;
                spLast = sp;
            } else if (ppLast != -1) {
                pp = ppLast;
                sp = ++spLast;
            } else
                return false;
        }

        while (pp < p.length() && p.charAt(pp) == '*') pp++;
        return pp == p.length();
    }
}