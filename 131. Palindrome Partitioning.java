public class Solution {
    private List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        partitionHelper(s, new ArrayList<String>());
        return res;
    }

    private void partitionHelper(String s, List<String> sol) {
        if (s.isEmpty()) {
            res.add(new ArrayList<String>(sol));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String subString = s.substring(0, i);
            if (isPalindrome(subString)) {
                sol.add(subString);
                partitionHelper(s.substring(i), sol);
                sol.remove(sol.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }
}