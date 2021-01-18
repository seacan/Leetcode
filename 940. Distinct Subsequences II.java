// Input: "aba"
// Output: 6
// Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
class Solution {
    public int distinctSubseqII(String S) {
        long end[] = new long[26], mod = (long)1e9 + 7;
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum()%mod + 1;
        return (int)(Arrays.stream(end).sum() % mod);
    }
}