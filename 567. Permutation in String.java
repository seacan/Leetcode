// Input: s1 = "ab" s2 = "eidbaooo"
// Output: True
// Explanation: s2 contains one permutation of s1 ("ba").
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int start = 0, match = 0;
        for (int end = 0; end < len2; end++) {
            char left = s2.charAt(end);
            if (map.containsKey(left)) {
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) match++;
            }
            if (match == map.size()) return true;
            if (end - start + 1 >= s1.length()) {
                char right = s2.charAt(start);
                if (map.containsKey(right)) {
                    if (map.get(right) == 0) match--;
                    map.put(right, map.get(right) + 1);
                }
                start++;
            }
        }
        return false;
    }
}