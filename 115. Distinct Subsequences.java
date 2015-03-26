public class Solution {
    public int numDistinct(String S, String T) {
        if (T.length() > S.length()) return 0;
        int[] mem = new int[T.length() + 1];
        mem[0] = 1;
        for (int i = 0; i < S.length(); i++)
            for (int j = T.length(); j >= 1; j--)
                if (S.charAt(i) == T.charAt(j - 1))
                    mem[j] += mem[j - 1];
        return mem[T.length()];
    }
}