public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] cut = new int[s.length() + 1];
        Arrays.fill(cut, Integer.MAX_VALUE);
        cut[s.length()] = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int l = i, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++)
                cut[l] = Math.min(cut[l], 1 + cut[r + 1]);
            for (int l = i, r = i + 1; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++)
                cut[l] = Math.min(cut[l], 1 + cut[r + 1]);
        }
        return cut[0];
    }
}