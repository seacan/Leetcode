public class Solution {
    // Solution 1: recursion
    private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        // return null if string has nothing
        if (digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, 0, sb, res);
        return res;
    }

    private void letterCombinationsHelper(String digits, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(new String(sb));
            return;
        }
        int cur = digits.charAt(index) - '0';
        for (int i = 0; i < mapping[cur].length(); i++) {
            sb.append(mapping[cur].charAt(i));
            letterCombinationsHelper(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Solution 2: without recursion
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits.isEmpty()) return res;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        while (res.get(0).length() != digits.length()) {
            String cur = res.remove(0);
            String map = mapping[Character.getNumericValue(digits.charAt(cur.length()))];
            for (char c : map.toCharArray()) {
                res.add(res.size(), cur + c);
            }
        }
        return res;
    }
}