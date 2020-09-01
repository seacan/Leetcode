public class Solution {
    // Solution 1: reverse to long type
    public int reverse(int x) {
        long reverse = 0;
    	int val = Math.abs(x);
    	while (val > 0) {
    		reverse = reverse * 10 + val % 10;
    		val /= 10;
    	}
    
        if (reverse > Integer.MAX_VALUE) return 0;
    	return x >= 0 ? (int) reverse : (int) reverse * -1;
    }

    // Solution 2: simpler and cleaner.
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = res * 10 + tail;
            if ((newResult - tail) / 10 != res) return 0;
            res = newResult;
            x = x / 10;
        }
        return res;
    }
}