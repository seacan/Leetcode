public class Solution {
    public int reverse(int x) {
        long reverse = 0;
    	int val = Math.abs(x);
    	while (val > 0) {
    		reverse = reverse * 10 + val % 10;
    		val /= 10;
    	}
    
    	if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
    		return 0;
    	return x >= 0 ? (int) reverse : (int) reverse * -1;
    }
}