public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end)))
                // use max to skip multiple same chars
                // "abba", last 'a' back move to index 1
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return maxLength;
    }
}