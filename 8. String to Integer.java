public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() == 0) return 0;

    	str = str.trim();
    	boolean isPositive = true;
    	if (str.charAt(0) == '-' || str.charAt(0) == '+') {
    		isPositive = str.charAt(0) == '+' ? true : false;
    		str = str.substring(1);
    	}
    
    	long val = 0;
    	for (int i = 0; i < str.length(); i++) {
    		int digit = str.charAt(i) - '0';
    		if (digit > 9 || digit < 0)
    			break;
    		val = val * 10 + digit;
    		if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE)
    			return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    	}
    	return isPositive ? (int) val : (int) val * -1;
    }
}