public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return true;
        if (s == null) return t.isEmpty();
        if (t == null) return s.isEmpty();
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            } else if (map.get(s.charAt(i)) != t.charAt(i)) return false;
        }
        return true;
    }
}