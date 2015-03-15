public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
    	int maxLength = 0;
    	String maxSubstring = null;
    	for (int i = 0; i < s.length(); i++) {
    		int l = i, r = i + 1, curLength = 0;
    		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    			curLength += 2;
    			l--;
    			r++;
    		}
    		if (curLength > maxLength) {
    			maxLength = curLength;
    			// left is moved 1 step more
    			maxSubstring = s.substring(l + 1, r);
    		}
    
    		l = i - 1;
    		r = i + 1;
    		curLength = 1;
    		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    			curLength += 2;
    			l--;
    			r++;
    		}
    		if (curLength > maxLength) {
    			maxLength = curLength;
    			maxSubstring = s.substring(l + 1, r);
    		}
    	}
    	return maxSubstring;
    }
}