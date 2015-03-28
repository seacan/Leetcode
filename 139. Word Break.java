public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return true;
        if (dict.contains(s)) return true;
        List<Integer> index = new ArrayList<Integer>();
        index.add(0);
        for (int i = 1; i <= s.length(); i++) {
            boolean found = false;
            for (Integer start : index)
                if (dict.contains(s.substring(start, i))) {
                    found = true;
                    break;
                }
            if (found) index.add(0, i);
        }
        return index.get(0) == s.length();
    }
}