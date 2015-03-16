public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (L == null || L.length == 0 || L[0].isEmpty() || L[0].length() == 0) return res;

        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (String str : L) count.put(str, count.containsKey(str) ? count.get(str) + 1 : 1);

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