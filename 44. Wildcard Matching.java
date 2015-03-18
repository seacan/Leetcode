public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        int sp = 0, pp = 0, match = 0, lastIndex = -1;
        while (sp < s.length()) {
            // check pp within the loop, so that it could track back
            // think about "hi" and "*?" test case
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                lastIndex = pp;
                match = sp;
                pp++;
            } else if (lastIndex != -1) {
                pp = lastIndex + 1;
                sp = ++match;
            } else
                return false;
        }

        while (pp < p.length() && p.charAt(pp) == '*') pp++;
        return pp == p.length();
    }
}