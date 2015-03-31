public class Solution {
    public int romanToInt(String s) {
        int res = 0;
    	if (s == null || s.length() == 0) return res;
    
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
    		put('M', 1000);
    		put('D', 500);
    		put('C', 100);
    		put('L', 50);
    		put('X', 10);
    		put('V', 5);
    		put('I', 1);
    	}};
    
    	int pre = 0;
    	for (int i = s.length() - 1; i >= 0; i--) {
    		int val = map.get(s.charAt(i));
    		// for equal case, also add it to result    		
		res += (value>=pre?value:-value);
		pre = value;
    	}
    
    	return res;
    }
}