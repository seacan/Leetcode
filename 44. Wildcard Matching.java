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


// Recursive solution (Timeout)
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.charAt(0) != '*') {
            if (isMatchHelper(s, 0, p, 0))
                return isMatch(s.substring(1), p.substring(1));
        } else {
            if (isMatch(s, p.substring(1)))
                return true;
            while (!s.isEmpty()) {
                if (isMatch(s.substring(1), p.substring(1)))
                    return true;
                s = s.substring(1);
            }
        }
        return false;
    }

    private boolean isMatchHelper(String s, int i, String p, int j) {
        if (i < s.length() && j < p.length())
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                return true;
        return false;
    }
}

// DP solution
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) dp[i][0] = false;
        for (int i = 1; i <= p.length(); i++)
            dp[0][i] = p.charAt(i - 1) != '*' ? false : dp[0][i - 1];

        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    for (int k = i; k >= 0; k--)
                        if (dp[k][j - 1])
                            dp[i][j] = true;
                }
            }

        return dp[s.length()][p.length()];
    }
}