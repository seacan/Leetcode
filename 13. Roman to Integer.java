public class Solution {
    public int romanToInt(String s) {        
    	if (s == null || s.length() == 0) return 0;
    
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
    		put('M', 1000);
    		put('D', 500);
    		put('C', 100);
    		put('L', 50);
    		put('X', 10);
    		put('V', 5);
    		put('I', 1);
    	}};
    
    	int res = 0, pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = map.get(s.charAt(i));
            res += val >= pre ? val : -val;
            pre = val;
        }
    
    	return res;
    }
}