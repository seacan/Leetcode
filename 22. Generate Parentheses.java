// Solution 1: resursive on n-1 results
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



// Solution 2: resursive on available count for left and right parenthesis
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        generateParenthesisHelper(n, n, sb, res);
        return res;
    }

    private void generateParenthesisHelper(int left, int right, StringBuilder sb, List<String> res) {
        if (left > right || left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(new String(sb));
            return;
        }
        if (left > 0) {
            sb.append('(');
            generateParenthesisHelper(left - 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            generateParenthesisHelper(left, right - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}