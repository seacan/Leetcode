public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int s1Length = s1.length(), s2Length = s2.length(), s3Length = s3.length();
        if (s1Length + s2Length != s3Length) return false;

        Boolean[][] mem = new Boolean[s1Length + 1][s2Length + 1];
        for (int i = 0; i <= s1Length; i++)
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    mem[0][0] = true;
                    continue;
                }

                if (i > 0 && mem[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    mem[i][j] = true;
                    continue;
                }

                if (j > 0 && mem[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    mem[i][j] = true;
                    continue;
                }

                mem[i][j] = false;
            }
        return mem[s1Length][s2Length];
    }
}