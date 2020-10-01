// Input: S = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;

        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char
        for (int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] = i;

        // record the end index of the current sub string
        int maxReach = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            maxReach = Math.maxmaxReach, map[S.charAt(i) - 'a']);
            if (maxReach == i) {
                list.add(maxReach - start + 1);
                start = maxReach + 1;
            }
        }
        return list;
    }
}