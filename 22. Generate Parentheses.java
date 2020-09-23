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


// Solution 3: DFS
public class Solution {
    public static List<String> generateValidParentheses(int num) {
        List<String> res = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.offer(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString cur = queue.poll();
            if (cur.openCount == num && cur.closeCount == num) res.add(cur.str);
            else {
                if (cur.openCount < num)
                    queue.add(new ParenthesesString(cur.str + "(", cur.openCount + 1, cur.closeCount));
                if (cur.openCount > cur.closeCount)
                    queue.add(new ParenthesesString(cur.str + ")", cur.openCount, cur.closeCount + 1));
            }
        }
        return res;
    }
}