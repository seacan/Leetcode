// Input: s = "barfoothefoobarman", words = ["foo","bar"]
// Output: [0,9]
// Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
// The output order does not matter, returning [9,0] is fine too.
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (L == null || L.length == 0 || L[0].isEmpty() || L[0].length() == 0) return res;

        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (String str : L) count.put(str, count.getOrDefault(str, 0) + 1);

        int size = L[0].length();
        for (int i = 0; i < S.length() - L.length * size + 1; i++) {
            if (count.containsKey(S.substring(i, i + size))) {
                HashMap<String, Integer> copy = new HashMap<String, Integer>(count);
                // use size of L as counter here to avoid checking pointer
                for (int j = 0; j < L.length; j++) {
                    String curStr = S.substring(i + j * size, i + (j + 1) * size);
                    // break when curStr is not in dictionary
                    if (!copy.containsKey(curStr)) break;
                    copy.put(curStr, copy.get(curStr) - 1);
                    if (copy.get(curStr) == 0) copy.remove(curStr);
                }
                if (copy.size() == 0) res.add(i);
            }
        }
        return res;
    }
}