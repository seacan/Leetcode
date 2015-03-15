public class Solution {
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