public class Solution {
    public int calculate(String s) {
        Deque<Integer> q = new LinkedList<Integer>();
        int res = 0, sign = 1;
        q.add(1);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isSpaceChar(s.charAt(i))) continue;
            if (s.charAt(i) == '(') {
                q.add(q.peekLast() * sign);
                sign = 1;
            } else if (s.charAt(i) == ')') q.pollLast();
            else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '-') sign = -1;
            else {
                int temp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    temp = temp * 10 + s.charAt(++i) - '0';
                res += temp * sign * q.peekLast();
            }
        }
        return res;
    }
}