public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        char[] s1array = s1.toCharArray();
        char[] s2array = s2.toCharArray();
        Arrays.sort(s1array); // sort
        Arrays.sort(s2array);
        if (!Arrays.equals(s1array, s2array)) return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && 
                isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) // seach rest of the string
                return true;
        }
        return false;
    }
}