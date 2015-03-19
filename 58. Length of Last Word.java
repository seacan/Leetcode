public class Solution {
    public int lengthOfLastWord(String s) {
        String[] parts = s.trim().split(" ");
        if (parts.length == 0) return 0;
        return parts[parts.length - 1].length();
    }
}