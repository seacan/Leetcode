public class Solution {
    private List<String> res = new ArrayList<String>();
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> sol = new ArrayList<String>();
        wordBreakHelper(s, dict, sol);
        return res;
    }

    private void wordBreakHelper(String s, Set<String> dict, List<String> sol) {
        if (s == null || s.length() == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sol.size() - 1; i++)
                sb.append(sol.get(i) + " ");
            sb.append(sol.get(sol.size() - 1));
            res.add(sb.toString());
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String subStr = s.substring(0, i);
            if (dict.contains(subStr) && containssuffix(dict, s, i)) {
                sol.add(subStr);
                wordBreakHelper(s.substring(i), dict, sol);
                sol.remove(sol.size() - 1);
            }
        }
    }
    
    private boolean containssuffix(Set<String> dict, String str, int index) {
        if (index >= str.length()) return true;
        for (int i = str.length() - 1; i >= index; i--)
            if (dict.contains(str.substring(i, str.length()))) return true;
        return false;
    }
}