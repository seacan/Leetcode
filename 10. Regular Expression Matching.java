public class Solution {
    // Solution 1: DP with recursion solution
    public boolean isMatch(String s, String p) {
    	if (p.isEmpty()) return s.isEmpty();
    	if (p.length() <= 1 || p.charAt(1) != '*') {
    		if (isMatchHelper(s, 0, p, 0))
    		    return isMatch(s.substring(1), p.substring(1));
    	} else {
    		if (isMatch(s, p.substring(2)))
    			return true;
    		while (isMatchHelper(s, 0, p, 0)) {
    			if (isMatch(s.substring(1), p.substring(2)))
    				return true;
    			s = s.substring(1);
    		}
    	}
    	return false;
    }
    
    private boolean isMatchHelper(String s, int i, String p, int j) {
    	if (i < s.length() && j < p.length())
    		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
    			return true;
    	return false;
    }
}


public class Solution {
    // Solution 2: DP with memory solution
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sLen = s.length(), pLen = p.length();
        boolean[][] M = new boolean[sLen + 1][pLen + 1];
        M[0][0] = true;
        for (int j = 2; j < pLen + 1; j += 2)
            if (p.charAt(j - 1) == '*' && M[0][j - 2])
                M[0][j] = true;
        for (int i = 1; i < sLen + 1; i++)
            for (int j = 1; j < pLen + 1; j++) {
                char curS = s.charAt(i - 1), curP = p.charAt(j - 1);
                if (curP == '.' || curS == curP)
                    M[i][j] = M[i - 1][j - 1];
                else if (curP == '*') {
                    char preP = p.charAt(j - 2);
                    if (preP != '.' && curS != preP)
                        M[i][j] = M[i][j - 2];
                    else
                        M[i][j] = (M[i][j - 2] || M[i - 1][j - 2] || M[i - 1][j]);
                }
            }
        return M[sLen][pLen];
    }
}