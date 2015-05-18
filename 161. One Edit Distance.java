public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i))
            return s.substring(s.length() >= t.length() ? i + 1 : i).equals(t.substring(t.length() >= s.length() ? i + 1 : i));
 
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}