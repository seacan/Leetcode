public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                // use max to skip multiple same chars, e.g. "abba"
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            maxLength = Math.max(maxLength, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return maxLength;
    }
}