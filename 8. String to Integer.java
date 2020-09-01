public class Solution {
    // Solution 1: reverse to long type
    public int myAtoi(String str) {
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
    		if (digit > 9 || digit < 0) break;
    		val = val * 10 + digit;
    		if (val > Integer.MAX_VALUE)
    			return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    	}
    	return isPositive ? (int) val : (int) val * -1;
    }

    // Solution 2: no long cast
    public int myAtoi(String str) {        
        str = str.trim();
        if (str == null || str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;   // don't forget i++
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7'))
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            base = base * 10 + (str.charAt(i++) - '0');  // don't forget i++
        }
        return base * sign;
    }
}