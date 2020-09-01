public class Solution {
    // Solution 1: reverse entirely
    public boolean isPalindrome(int x) {
        int reverse = 0;
    	int val = x;
    	while (x > 0) {
    		reverse = reverse * 10 + x % 10;
    		x /= 10;
    	}
    	return reverse == val;
    }

    // Solution 2: reverse and compare by half
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}