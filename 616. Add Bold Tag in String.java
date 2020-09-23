class Solution {
    public String addBoldTag(String s, List<String> dict) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        Set<Integer> bold = new HashSet<>();
        for (String word : dict) {
            int len = word.length();
            for (int i = 0; i <= n - len; i++)
                if (s.charAt(i) == word.charAt(0) && s.substring(i, len + 1) == word)
                    for (int j = i; j < i + len; ++j) bold.add(j);
        }
        for (int i = 0; i < n; i++) {
            if (bold.contains(i) && !bold.contains(i - 1)) res.append("<b>");
            res.append(s.charAt(i));
            if (bold.contains(i) && !bold.contains(i + 1)) res.append("</b>");
        }
        return res.toString();
    }
}