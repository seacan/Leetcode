public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 1) {
            res.add("()");
            return res;
        }

        HashSet<String> cur = new HashSet<String>();
        List<String> pre = generateParenthesis(n - 1);
        for (String s : pre) {
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '(')
                    cur.add(s.substring(0, i + 1) + "()" + s.substring(i + 1));
            cur.add(s + "()");
        }
        res.addAll(cur);
        return res;
    }
}