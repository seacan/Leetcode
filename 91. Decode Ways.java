public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] mem = new int[s.length() + 1];
        mem[s.length()] = 1;
        mem[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else mem[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? mem[i + 1] + mem[i + 2] : mem[i + 1];
        }
        return mem[0];
    }
}